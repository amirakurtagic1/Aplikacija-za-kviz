package ba.etf.rma21.projekat.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import ba.etf.rma21.projekat.data.models.*
import java.util.*

class KvizRepository {

    companion object {
        // TODO: Implementirati
        init {
            // TODO: Implementirati
        }
        lateinit var noviKviz: Kviz

        @RequiresApi(Build.VERSION_CODES.O)
        fun addKviz(predmet: Predmet, grupa: Grupa){
            var sviKvizovi: List<Kviz> = getAll()
            for(kviz in sviKvizovi){
                println("OVDJEEE SAM: " + predmet.naziv + " " + kviz.nazivPredmeta + " " + grupa.naziv + " " + kviz.nazivGrupe)
                if(predmet.naziv.equals(kviz.nazivPredmeta) && grupa.naziv.equals(kviz.nazivGrupe)) {
                    noviKviz = kviz
                }
            }
            //return noviKviz;
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getMyKvizes(): List<Kviz> {
            // TODO: Implementirati: kvizovi za predmete i grupe gdje je korisnik upisan
            var mojiKvizovi: List<Kviz> = myKvizes()
            if(this::noviKviz.isInitialized) mojiKvizovi += noviKviz
            return mojiKvizovi
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getAll(): List<Kviz> {
            // TODO: Implementirati: svi kvizovi u aplikaciji
            return kvizes()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getDone(): List<Kviz> {
            // TODO: Implementirati: moji kvizovi koji su uradjeni
            return doneKvizes()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getFuture(): List<Kviz> {
            // TODO: Implementirati: moji kvizovi koji su budući
            return futureKvizes()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getNotTaken(): List<Kviz> {
            // TODO: Implementirati: moji kvizovi koji su prošli ali nisu urađeni
            return notTakenKvizes()
        }

        // TODO: Implementirati i ostale potrebne metode
    }
}