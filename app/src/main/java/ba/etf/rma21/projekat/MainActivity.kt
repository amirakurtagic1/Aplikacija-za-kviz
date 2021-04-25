package ba.etf.rma21.projekat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.view.FragmentKvizovi
import ba.etf.rma21.projekat.view.FragmentPoruka
import ba.etf.rma21.projekat.view.FragmentPredmeti
import ba.etf.rma21.projekat.view.KvizListAdapter
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var kvizoviRecyclerView: RecyclerView
    private lateinit var filterKvizova: Spinner
    private lateinit var kvizListAdapter: KvizListAdapter
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()
    private var kvizovi: KvizRepository = KvizRepository()

     lateinit var bottomNav: BottomNavigationView


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.kvizovi -> {
                val kvizoviFragment = FragmentKvizovi.newInstance()
                openFragment(kvizoviFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.predmeti -> {
                val predmetiFragment = FragmentPredmeti.newInstance()
                openFragment(predmetiFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeforFragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        bottomNav= findViewById(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        //Defaultni fragment
        bottomNav.selectedItemId= R.id.kvizovi
        val kvizoviFragment = FragmentKvizovi.newInstance()
        openFragment(kvizoviFragment)

       // bottomNav.menu.findItem(R.id.predajKviz).isEnabled = false;
       // bottomNav.menu.findItem(R.id.zaustaviKviz).isEnabled = false;

        bottomNav.menu.findItem(R.id.predajKviz).setVisible(false);
        bottomNav.menu.findItem(R.id.zaustaviKviz).setVisible(false);













        /*   kvizoviRecyclerView = findViewById(R.id.listaKvizova)

           kvizoviRecyclerView.layoutManager = GridLayoutManager(this, 2)
           kvizListAdapter = KvizListAdapter(arrayListOf())
           kvizoviRecyclerView.adapter = kvizListAdapter
           kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getAll()))





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
       }
       override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
           super.onActivityResult(requestCode, resultCode, data)
           if (requestCode == 1) {
               if (resultCode == Activity.RESULT_OK) {

                   if(filterKvizova.selectedItem.equals("Svi moji kvizovi"))kvizListAdapter.updateKvizes(kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyKvizes()))
               }
           }*/

        }

    fun prilagodiBottomNavigation(){
        bottomNav.menu.findItem(R.id.kvizovi).setVisible(false);
        bottomNav.menu.findItem(R.id.predmeti).setVisible(false);
        bottomNav.menu.findItem(R.id.predajKviz).setVisible(true)
        bottomNav.menu.findItem(R.id.zaustaviKviz).setVisible(true)
        //bottomNav.menu.getItem(3).setVisible(true)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (filterKvizova.selectedItem.equals("Svi moji kvizovi")) kvizListAdapter.updateKvizes(
                    kvizListAdapter.filterKvizesByDate(kvizListViewModel.getMyKvizes())
                )
                var frPoruka = FragmentPoruka.newInstance("Neka poruka");
                openFragment(frPoruka)

            }
        }
    }
}

