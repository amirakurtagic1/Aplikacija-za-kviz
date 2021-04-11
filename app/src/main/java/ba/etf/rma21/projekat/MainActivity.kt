package ba.etf.rma21.projekat

import android.content.Intent
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
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
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var kvizoviRecyclerView: RecyclerView
    private lateinit var filterKvizova: Spinner
    private lateinit var kvizListAdapter: KvizListAdapter
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()
    private var kvizovi: KvizRepository = KvizRepository()
    private lateinit var dodajButton: FloatingActionButton

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kvizoviRecyclerView = findViewById(R.id.listaKvizova)
        kvizoviRecyclerView.layoutManager = GridLayoutManager(this, 2)
        kvizListAdapter = KvizListAdapter(arrayListOf())
        kvizoviRecyclerView.adapter = kvizListAdapter
        kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getAll()))

        dodajButton = findViewById(R.id.upisDugme)


        filterKvizova = findViewById(R.id.filterKvizova)
        val arraySpinner = arrayOf(
                "Svi moji kvizovi", "Svi kvizovi", "Urađeni kvizovi", "Budući kvizovi", "Prošli kvizovi"
        )
        var selektovana = ""
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        filterKvizova.adapter = adapter

        filterKvizova.setSelection(1)
        filterKvizova.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
               selektovana = filterKvizova.selectedItem.toString()
                if(selektovana.equals("Svi moji kvizovi")) {
                    kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyKvizes()))
                }
                else if(selektovana.equals("Svi kvizovi")) {
                    kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getAll()))
                }
                else if(selektovana.equals("Urađeni kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getDone()))
                else if(selektovana.equals("Budući kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getFuture()))
                else if(selektovana.equals("Prošli kvizovi (neurađeni)")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getNotTaken()))
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        println("Probaaaaa")
        println(predmetiByGodina(1).size)
        for(kviz in myKvizes())  println(kviz.naziv + " " + kviz.datumKraj)


        dodajButton.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    UpisPredmet::class.java
                )
            )
        })
    }
}

