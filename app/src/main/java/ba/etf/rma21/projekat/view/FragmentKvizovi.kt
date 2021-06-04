package ba.etf.rma21.projekat.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.data.repositories.PitanjeKvizRepository
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel
import kotlinx.coroutines.*

class FragmentKvizovi: Fragment() {

    private lateinit var kvizoviRecyclerView: RecyclerView
    private lateinit var filterKvizova: Spinner
    private lateinit var kvizListAdapter: KvizListAdapter
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()
    private var kvizovi: KvizRepository = KvizRepository()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_kvizovi, container, false)
        kvizoviRecyclerView = view.findViewById(R.id.listaKvizova)

        kvizoviRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        kvizListAdapter = KvizListAdapter(arrayListOf())
        kvizoviRecyclerView.adapter = kvizListAdapter

        kvizListViewModel.getAll(onSuccess = ::onSuccess, onError = ::onError)
       // kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getAll()))

       // println(PitanjeKvizRepository.getPitanja(1))

        filterKvizova = view.findViewById(R.id.filterKvizova)
        val arraySpinner = arrayOf(
            "Svi moji kvizovi", "Svi kvizovi", "Urađeni kvizovi", "Budući kvizovi", "Prošli kvizovi"
        )
        var selektovana = ""
        val adapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item, arraySpinner)
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        filterKvizova.adapter = adapter
        val scope = CoroutineScope(Job() + Dispatchers.Main)


        filterKvizova.setSelection(1)
            filterKvizova.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View,
                        position: Int,
                        id: Long
                    ) {
                        GlobalScope.launch(Dispatchers.IO)
                        {
                            selektovana = filterKvizova.selectedItem.toString()
                            if (selektovana.equals("Svi moji kvizovi")) {
                                withContext(Dispatchers.Main) { myApiCall() }
                            } else if (selektovana.equals("Svi kvizovi")) {
                                kvizListViewModel.getAll(
                                    onSuccess = ::onSuccess,
                                    onError = ::onError
                                )
                            } //else if (selektovana.equals("Urađeni kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyDoneKvizes()))
                            //else if (selektovana.equals("Budući kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyFutureKvizes()))
                            //else if (selektovana.equals("Prošli kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyNotTakenKvizes()))
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {

                    }
                }


     fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

             //   if(filterKvizova.selectedItem.equals("Svi moji kvizovi"))kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyKvizes()))
            }
        }
    }
        return view;
    }

    suspend fun myApiCall() {
       GlobalScope.launch(Dispatchers.IO) {
           kvizListViewModel.getUpisani(
               onSuccess = ::onSuccessMojiKvizovi,
               onError = ::onErrorMojiKvizovi
           )
           delay(10_000)
       }
      //  delay(10_000) // 10 second delay koji imitira mrežni poziv
    }

    fun onSuccess(kvizovi:List<Kviz>?){
        println("Dosla sam ovdje")
        val toast = Toast.makeText(context, "Svi kvizovi pronađeni", Toast.LENGTH_SHORT)
        toast.show()
        kvizListAdapter.updateKvizes(kvizovi)
    }
    fun onError() {
        println("Error pronadjeeen");
        val toast = Toast.makeText(context, "Search error", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun onSuccessMojiKvizovi(kvizovi:List<Kviz>?){
        println("Dosla sam ovdje")
        val toast = Toast.makeText(context, "Svi kvizovi pronađeni", Toast.LENGTH_SHORT)
        toast.show()
        kvizListAdapter.updateKvizes(kvizovi)
    }
    fun onErrorMojiKvizovi() {
        println("Error pronadjeeen");
        val toast = Toast.makeText(context, "Search error", Toast.LENGTH_SHORT)
        toast.show()
    }
    companion object {
        fun newInstance(): FragmentKvizovi = FragmentKvizovi()
    }



}