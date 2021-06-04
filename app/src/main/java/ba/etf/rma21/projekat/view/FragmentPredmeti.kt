package ba.etf.rma21.projekat.view

import android.app.FragmentTransaction
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetiIGrupeListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentPredmeti: Fragment() {

    private lateinit var odabirGodina: Spinner
    private lateinit var odabirPredmet: Spinner
    private lateinit var odabirGrupa: Spinner
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()
    private var predmetiIGrupeListViewModel = PredmetiIGrupeListViewModel()
    private lateinit var upisiPredmet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This callback will only be called when MyFragment is at least Started.
        //val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
          //  // Handle the back button event
       // }

        // The callback can be enabled or disabled here or in the lambda
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_predmeti, container, false)


        upisiPredmet = view.findViewById(R.id.dodajPredmetDugme)
        upisiPredmet.isEnabled = false;
        upisiPredmet.isClickable = false;



        odabirGodina = view.findViewById(R.id.odabirGodina)
        val godineSpinner = arrayOf(
            "1", "2", "3", "4", "5"
        )
        var selektovanaGodina = 0
        val adapterGodina = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item, godineSpinner
            )
        }
        if (adapterGodina != null) {
            adapterGodina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        odabirGodina.adapter = adapterGodina

        odabirPredmet = view.findViewById(R.id.odabirPredmet)
        var predmetiSpinner = mutableListOf<String>()
        var selektovaniPredmet = ""
        val adapterPredmet = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item, predmetiSpinner
            )
        }
        if (adapterPredmet != null) {
            adapterPredmet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        odabirPredmet.adapter = adapterPredmet

        odabirGrupa = view.findViewById(R.id.odabirGrupa)
        val grupeSpinner = mutableListOf<String>()
        var selektovanaGrupa = ""
        val adapterGrupa = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item, grupeSpinner
            )
        }
        if (adapterGrupa != null) {
            adapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        odabirGrupa.adapter = adapterGrupa

        //  odabirPredmet.isEnabled = false;
        //  odabirPredmet.isClickable = false;

        //  odabirGrupa.isEnabled = false;
        // odabirGrupa.isClickable = false;


        var postoji = false;



        odabirGodina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                GlobalScope.launch {
                    predmetiSpinner.clear()
                    grupeSpinner.clear()
                    if (adapterPredmet != null) {
                        withContext(Dispatchers.Main){
                            adapterPredmet.clear()
                        }
                    }

                    if (adapterGrupa != null) {
                        withContext(Dispatchers.Main) {
                            adapterGrupa.clear()
                        }
                    }

                    upisiPredmet.isEnabled = false;
                    upisiPredmet.isClickable = false;

                    //  odabirPredmet.isClickable = true;
                    //odabirPredmet.isEnabled = true;
                    selektovanaGodina = odabirGodina.selectedItem.toString().toInt()
                    println("SELEKTOVANA GODINA: " + selektovanaGodina)
                    var predmetiGodine = predmetListViewModel.getPredmetsByGodina(selektovanaGodina)


                    for (predmet in predmetiGodine!!) {
                        for (upisaniPredmet in predmetListViewModel.getUpisani()!!) {
                            if (predmet.equals(upisaniPredmet)) postoji = true;
                        }
                        if (postoji.equals(false)) {
                            println("DODAJEM OVAJ PREDMET: " + predmet.naziv)
                            predmetiSpinner.add(predmet.naziv)
                        } else {
                            postoji = false;
                        }
                    }

                    if (predmetiSpinner.size !== 0) {
                        var grupePoPredmetu =
                            grupaListViewModel.getGroupsByPredmet(predmetiSpinner[0])


                        if (grupePoPredmetu != null) {
                            for (grupa in grupePoPredmetu) {
                                grupeSpinner.add(grupa.naziv)
                            }
                        }
                        if (grupePoPredmetu !== null) {
                            withContext(Dispatchers.Main) {
                                upisiPredmet.isClickable = true;
                                upisiPredmet.isEnabled = true;
                            }
                        }

                        if (adapterPredmet != null) {
                            withContext(Dispatchers.Main) {
                                adapterPredmet.notifyDataSetChanged()
                            }
                        }
                        if (adapterGrupa != null) {
                            withContext(Dispatchers.Main) {
                                adapterGrupa.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        odabirPredmet.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                GlobalScope.launch(Dispatchers.IO) {
                    if (adapterGrupa != null) {
                        withContext(Dispatchers.Main) {
                            adapterGrupa.clear()
                        }
                    }
                    grupeSpinner.clear()
                    // odabirGrupa.isEnabled = true;
                    // odabirGrupa.isClickable = true;
                    selektovaniPredmet = odabirPredmet.selectedItem.toString()
                    // else selektovaniPredmet = odabirPredmet.get(0).toString()

                    var grupePoPredmetu = grupaListViewModel.getGroupsByPredmet(selektovaniPredmet)


                    if (grupePoPredmetu != null) {
                        for (grupa in grupePoPredmetu) {
                            grupeSpinner.add(grupa.naziv)
                        }
                    }
                    // adapterPredmet.clear()
                    //adapterPredmet.addAll(predmetiSpinner)
                    if (adapterGrupa != null) {
                        withContext(Dispatchers.Main) {
                            adapterGrupa.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        odabirGrupa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                upisiPredmet.isClickable = true;
                upisiPredmet.isEnabled = true;
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }

            fun onSuccess(predmeti:List<Predmet>?){
                println("Dosla sam ovdje")
                val toast = Toast.makeText(context, "Svi kvizovi pronađeni", Toast.LENGTH_SHORT)
                toast.show()
            }
            fun onError() {
                println("Error pronadjeeen");
                val toast = Toast.makeText(context, "Search error", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        upisiPredmet.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                var listaPredmeta = predmetListViewModel.getPredmetsByGodina(odabirGodina.selectedItem.toString().toInt());
                var id: Int?
                id = 0;
                for(x in listaPredmeta!!){
                    if(x.naziv.equals(odabirPredmet.selectedItem.toString())) id = x.id;
                }
               /* predmetListViewModel.addPredmetToUpisani(
                    Predmet(id,
                        odabirPredmet.selectedItem.toString(),
                        odabirGodina.selectedItem.toString().toInt()
                    )
                )*/
                var grupa: Grupa?
                grupa = null

                var sveGrupe = grupaListViewModel.getGroups();
                if (sveGrupe != null) {
                    for(x in sveGrupe){
                        if(x.PredmetId.equals(id) && x.naziv.equals(odabirGrupa.selectedItem.toString())) grupa = x;
                    }
                }
                grupa?.id?.let { it1 -> predmetiIGrupeListViewModel.upisiUGrupu(it1) }
                // println("Selektovani predmet: " + odabirPredmet.selectedItem.toString())
                //println("Selektovana godina: " + odabirGodina.selectedItem.toString())
               // for (kviz in kvizListViewModel.getMyKvizes()) println("Moj upisani predmet: " + kviz)

                val fragmentPoruka =
                    FragmentPoruka("Uspješno ste upisani u grupu ${grupa!!.naziv} predmeta ${odabirPredmet.selectedItem.toString()}!");
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.placeforFragment, fragmentPoruka, "findThisFragment")
                    ?.addToBackStack(null)
                    ?.commit()
            }
           // setResult(Activity.RESULT_OK, i)
           // getActivity()?.startActivity(i);
        }

        return view;
    }



    companion object {
        fun newInstance(): FragmentPredmeti = FragmentPredmeti()
    }



}

