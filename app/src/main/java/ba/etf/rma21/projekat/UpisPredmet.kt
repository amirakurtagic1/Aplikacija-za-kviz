package ba.etf.rma21.projekat

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class UpisPredmet:  AppCompatActivity() {

    private lateinit var odabirGodina: Spinner
    private lateinit var odabirPredmet: Spinner
    private lateinit var odabirGrupa: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upis_predmet)


        odabirGodina = findViewById(R.id.odabirGodina)
        val godineSpinner = arrayOf(
                1,2,3,4,5
        )
        var selektovanaGodina = ""
        val adapterGodina = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, godineSpinner)
        adapterGodina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirGodina.adapter = adapterGodina

        odabirPredmet = findViewById(R.id.odabirPredmet)
        val predmetiSpinner = arrayOf(
            1,2,3,4,5
        )
        var selektovaniPredmet = ""
        val adapterPredmet = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, predmetiSpinner)
        adapterPredmet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirPredmet.adapter = adapterPredmet

        odabirGrupa = findViewById(R.id.odabirGrupa)
        val grupeSpinner = arrayOf(
            1,2,3,4,5
        )
        var selektovanaGrupa = ""
        val adapterGrupa = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, grupeSpinner)
        adapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        odabirGrupa.adapter = adapterGrupa
    }
}