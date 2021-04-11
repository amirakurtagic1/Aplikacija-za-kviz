package ba.etf.rma21.projekat

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.viewModel.GrupaListViewModel
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel

class UpisPredmet:  AppCompatActivity() {

    private lateinit var odabirGodina: Spinner
    private lateinit var odabirPredmet: Spinner
    private lateinit var odabirGrupa: Spinner
    private var grupaListViewModel = GrupaListViewModel()
    private var kvizListViewModel = KvizListViewModel()
    private var predmetListViewModel = PredmetListViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upis_predmet)


        odabirGodina = findViewById(R.id.odabirGodina)
        val godineSpinner = arrayOf(
            1, 2, 3, 4, 5
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


    var postoji = false;

        odabirGodina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                predmetiSpinner.clear()
                selektovanaGodina = odabirGodina.selectedItem.toString().toInt()
                println("SELEKTOVANA GODINA: " + selektovanaGodina)
                var predmetiGodine = predmetListViewModel.getPredmetsByGodina(selektovanaGodina)

                for(predmet in predmetiGodine)println("PREDMET: " + predmet)

                for(predmet in predmetiGodine){
                    for(upisaniPredmet in predmetListViewModel.getUpisani()){
                        if(predmet.equals(upisaniPredmet)) postoji = true;
                    }
                    if(postoji.equals(false)){
                        println("DODAJEM OVAJ PREDMET: " + predmet.naziv)
                        predmetiSpinner.add(predmet.naziv)
                    } else {
                        postoji = false;
                    }
                }

               // adapterPredmet.clear()
                //adapterPredmet.addAll(predmetiSpinner)
                adapterPredmet.notifyDataSetChanged()

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
                grupeSpinner.clear()
                selektovaniPredmet = odabirPredmet.selectedItem.toString()

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
    }
}