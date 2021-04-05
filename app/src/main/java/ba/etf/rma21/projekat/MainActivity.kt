package ba.etf.rma21.projekat

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ba.etf.rma21.projekat.data.models.*
import ba.etf.rma21.projekat.data.repositories.KvizRepository


class MainActivity : AppCompatActivity() {

    private var kvizovi: KvizRepository = KvizRepository()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("Probaaaaa")
        println(predmetiByGodina(1).size)
        for(kviz in myKvizes())  println(kviz.naziv + " " + kviz.datumKraj)
    }
}

