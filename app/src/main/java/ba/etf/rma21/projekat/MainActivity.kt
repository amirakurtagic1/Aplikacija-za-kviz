package ba.etf.rma21.projekat

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.data.models.myKvizes
import ba.etf.rma21.projekat.data.models.predmetiByGodina
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.view.KvizListAdapter
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var kvizoviRecyclerView: RecyclerView
    private lateinit var filterKvizova: Spinner
    private lateinit var kvizListAdapter: KvizListAdapter
    private lateinit var grupaListViewModel: GrupaListViewModel
    private var kvizListViewModel = KvizListViewModel()
    private lateinit var predmetListViewModel: PredmetListViewModel
    private var kvizovi: KvizRepository = KvizRepository()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kvizoviRecyclerView = findViewById(R.id.listaKvizova)
        kvizoviRecyclerView.layoutManager = GridLayoutManager(this, 2)
        kvizListAdapter = KvizListAdapter(arrayListOf())
        kvizoviRecyclerView.adapter = kvizListAdapter
        kvizListAdapter.updateKvizes(kvizListViewModel.getAll())




        filterKvizova = findViewById(R.id.filterKvizova)
        val arraySpinner = arrayOf(
                "Svi moji kvizovi", "Svi kvizovi", "Urađeni kvizovi", "Budući kvizovi", "Prošli kvizovi (neurađeni)"
        )
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        filterKvizova.setAdapter(adapter)





        println("Probaaaaa")
        println(predmetiByGodina(1).size)
        for(kviz in myKvizes())  println(kviz.naziv + " " + kviz.datumKraj)
    }
    class MarginItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
                outRect: Rect, view: View,
                parent: RecyclerView,
                state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceSize
                }
                left = spaceSize
                right = spaceSize
                bottom = spaceSize
            }
        }
    }

}

