package ba.etf.rma21.projekat

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.view.FragmentPoruka
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UpisPredmet:  AppCompatActivity() {

   /* private lateinit var odabirGodina: Spinner
    private lateinit var odabirPredmet: Spinner
    private lateinit var odabirGrupa: Spinner
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()
    private lateinit var upisiPredmet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upis_predmet)

        upisiPredmet = findViewById(R.id.dodajPredmetDugme)
        upisiPredmet.isEnabled = false;
        upisiPredmet.isClickable = false;



        odabirGodina = findViewById(R.id.odabirGodina)
        val godineSpinner = arrayOf(
            "1", "2", "3", "4", "5"
        )
        var selektovanaGodina = 0
        val adapterGodina = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, godineSpinner
        )
        adapterGodina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirGodina.adapter = adapterGodina

        odabirPredmet = findViewById(R.id.odabirPredmet)
        var predmetiSpinner = mutableListOf<String>()
        var selektovaniPredmet = ""
        val adapterPredmet = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, predmetiSpinner
        )
        adapterPredmet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirPredmet.adapter = adapterPredmet

        odabirGrupa = findViewById(R.id.odabirGrupa)
        val grupeSpinner = mutableListOf<String>()
        var selektovanaGrupa = ""
        val adapterGrupa = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, grupeSpinner
        )
        adapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirGrupa.adapter = adapterGrupa

      //  odabirPredmet.isEnabled = false;
      //  odabirPredmet.isClickable = false;

      //  odabirGrupa.isEnabled = false;
       // odabirGrupa.isClickable = false;


        var postoji = false;



        odabirGodina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                GlobalScope.launch(Dispatchers.IO) {
                    predmetiSpinner.clear()
                    grupeSpinner.clear()
                    adapterPredmet.clear()
                    adapterGrupa.clear()

                    upisiPredmet.isEnabled = false;
                    upisiPredmet.isClickable = false;

                    //  odabirPredmet.isClickable = true;
                    //odabirPredmet.isEnabled = true;
                    selektovanaGodina = odabirGodina.selectedItem.toString().toInt()
                    println("SELEKTOVANA GODINA: " + selektovanaGodina)
                    var predmetiGodine = predmetListViewModel.getPredmetsByGodina(selektovanaGodina)


                    if (predmetiGodine != null) {
                        for (predmet in predmetiGodine) {
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
                            upisiPredmet.isClickable = true;
                            upisiPredmet.isEnabled = true;
                        }

                        adapterPredmet.notifyDataSetChanged()
                        adapterGrupa.notifyDataSetChanged()
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        odabirPredmet.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                adapterGrupa.clear()
                grupeSpinner.clear()
               // odabirGrupa.isEnabled = true;
               // odabirGrupa.isClickable = true;
                selektovaniPredmet = odabirPredmet.selectedItem.toString()
               // else selektovaniPredmet = odabirPredmet.get(0).toString()

                var grupePoPredmetu = grupaListViewModel.getGroupsByPredmet(selektovaniPredmet)


                for(grupa in grupePoPredmetu){
                    grupeSpinner.add(grupa.naziv)
                }
                // adapterPredmet.clear()
                //adapterPredmet.addAll(predmetiSpinner)
                adapterGrupa.notifyDataSetChanged()

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        odabirGrupa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
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
           /* predmetListViewModel.addPredmetToUpisani(Predmet(odabirPredmet.selectedItem.toString(), odabirGodina.selectedItem.toString().toInt()))
            val grupa = Grupa(odabirGrupa.selectedItem.toString(), odabirPredmet.selectedItem.toString());
            kvizListViewModel.addKvizToMyKvizes(Predmet(odabirPredmet.selectedItem.toString(), odabirGodina.selectedItem.toString().toInt()), Grupa(odabirGrupa.selectedItem.toString(), odabirPredmet.selectedItem.toString()))
           // println("Selektovani predmet: " + odabirPredmet.selectedItem.toString())
            //println("Selektovana godina: " + odabirGodina.selectedItem.toString())
            for(kviz in kvizListViewModel.getMyKvizes()) println("Moj upisani predmet: " + kviz)

            val fragmentPoruka = FragmentPoruka.newInstance("Neka poruka");
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.placeforFragment, fragmentPoruka)
            transaction.addToBackStack(null)
            transaction.commit()
            val resultIntent = Intent()
            setResult(Activity.RESULT_OK, resultIntent)
            finish()*/
        }

    }
*/

}

