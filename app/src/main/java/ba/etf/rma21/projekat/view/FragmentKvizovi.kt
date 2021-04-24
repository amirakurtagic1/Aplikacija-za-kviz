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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel

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
        kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getAll()))



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

        filterKvizova.setSelection(1)
        filterKvizova.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selektovana = filterKvizova.selectedItem.toString()
                if (selektovana.equals("Svi moji kvizovi")) {
                    kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyKvizes()))
                } else if (selektovana.equals("Svi kvizovi")) {
                    kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getAll()))
                } else if (selektovana.equals("Urađeni kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyDoneKvizes()))
                else if (selektovana.equals("Budući kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyFutureKvizes()))
                else if (selektovana.equals("Prošli kvizovi")) kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyNotTakenKvizes()))
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

     fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                if(filterKvizova.selectedItem.equals("Svi moji kvizovi"))kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyKvizes()))
            }
        }
    }
        return view;
    }
    companion object {
        fun newInstance(): FragmentKvizovi = FragmentKvizovi()
    }



}