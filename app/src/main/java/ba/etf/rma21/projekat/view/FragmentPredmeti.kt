package ba.etf.rma21.projekat.view

import android.app.FragmentTransaction
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel


class FragmentPredmeti: Fragment() {

    private lateinit var odabirGodina: Spinner
    private lateinit var odabirPredmet: Spinner
    private lateinit var odabirGrupa: Spinner
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()
    private lateinit var upisiPredmet: Button

  /*  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This callback will only be called when MyFragment is at least Started.
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
        }

        // The callback can be enabled or disabled here or in the lambda
    }*/

/*
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
                predmetiSpinner.clear()
                grupeSpinner.clear()
                if (adapterPredmet != null) {
                    adapterPredmet.clear()
                }
                if (adapterGrupa != null) {
                    adapterGrupa.clear()
                }

                upisiPredmet.isEnabled = false;
                upisiPredmet.isClickable = false;

                //  odabirPredmet.isClickable = true;
                //odabirPredmet.isEnabled = true;
                selektovanaGodina = odabirGodina.selectedItem.toString().toInt()
                println("SELEKTOVANA GODINA: " + selektovanaGodina)
                var predmetiGodine = predmetListViewModel.getPredmetsByGodina(selektovanaGodina)

                for (predmet in predmetiGodine) println("PREDMET: " + predmet)

                for (predmet in predmetiGodine) {
                    for (upisaniPredmet in predmetListViewModel.getUpisani()) {
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
                    var grupePoPredmetu = grupaListViewModel.getGroupsByPredmet(predmetiSpinner[0])


                    for (grupa in grupePoPredmetu) {
                        grupeSpinner.add(grupa.naziv)
                    }
                    if (grupePoPredmetu.size !== 0) {
                        upisiPredmet.isClickable = true;
                        upisiPredmet.isEnabled = true;
                    }

                    if (adapterPredmet != null) {
                        adapterPredmet.notifyDataSetChanged()
                    }
                    if (adapterGrupa != null) {
                        adapterGrupa.notifyDataSetChanged()
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
                if (adapterGrupa != null) {
                    adapterGrupa.clear()
                }
                grupeSpinner.clear()
                // odabirGrupa.isEnabled = true;
                // odabirGrupa.isClickable = true;
                selektovaniPredmet = odabirPredmet.selectedItem.toString()
                // else selektovaniPredmet = odabirPredmet.get(0).toString()

                var grupePoPredmetu = grupaListViewModel.getGroupsByPredmet(selektovaniPredmet)


                for (grupa in grupePoPredmetu) {
                    grupeSpinner.add(grupa.naziv)
                }
                // adapterPredmet.clear()
                //adapterPredmet.addAll(predmetiSpinner)
                if (adapterGrupa != null) {
                    adapterGrupa.notifyDataSetChanged()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

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
        }

        upisiPredmet.setOnClickListener {
            predmetListViewModel.addPredmetToUpisani(Predmet(odabirPredmet.selectedItem.toString(), odabirGodina.selectedItem.toString().toInt()))
            var grupa = Grupa(odabirGrupa.selectedItem.toString(), odabirPredmet.selectedItem.toString());
            kvizListViewModel.addKvizToMyKvizes(Predmet(odabirPredmet.selectedItem.toString(), odabirGodina.selectedItem.toString().toInt()), Grupa(odabirGrupa.selectedItem.toString(), odabirPredmet.selectedItem.toString()))
            // println("Selektovani predmet: " + odabirPredmet.selectedItem.toString())
            //println("Selektovana godina: " + odabirGodina.selectedItem.toString())
            for(kviz in kvizListViewModel.getMyKvizes()) println("Moj upisani predmet: " + kviz)

            val fragmentPoruka = FragmentPoruka("Uspješno ste upisani u grupu ${grupa.naziv} predmeta ${grupa.nazivPredmeta}!");
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.placeforFragment, fragmentPoruka, "findThisFragment")
                ?.addToBackStack(null)
                ?.commit()
           // setResult(Activity.RESULT_OK, i)
           // getActivity()?.startActivity(i);
        }

        return view;
    }
*/


    companion object {
        fun newInstance(): FragmentPredmeti = FragmentPredmeti()
    }



}

