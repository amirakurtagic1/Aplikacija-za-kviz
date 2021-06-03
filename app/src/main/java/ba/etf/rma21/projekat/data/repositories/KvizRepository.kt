package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KvizRepository {

    companion object {
        /*    // TODO: Implementirati
        init {
            // TODO: Implementirati
        }
       lateinit var noviKviz: Kviz
        var noviKvizoviLista = emptyList<Kviz>()

        fun addKviz(predmet: Predmet, grupa: Grupa){
            var sviKvizovi: List<Kviz> = getAll()
            for(kviz in sviKvizovi){
                println("OVDJEEE SAM: " + predmet.naziv + " " + kviz.nazivPredmeta + " " + grupa.naziv + " " + kviz.nazivGrupe)
                if(predmet.naziv.equals(kviz.nazivPredmeta) && grupa.naziv.equals(kviz.nazivGrupe)) {
                    noviKviz = kviz
                    noviKvizoviLista += noviKviz
                }
            }
            //return noviKviz;
        }

        fun getMyKvizes(): List<Kviz> {
            // TODO: Implementirati: kvizovi za predmete i grupe gdje je korisnik upisan
            var mojiKvizovi: List<Kviz> = myKvizes()
            if(this::noviKviz.isInitialized) {
                mojiKvizovi += noviKvizoviLista
            }
            return mojiKvizovi
        }

        fun getAll(): List<Kviz> {
            // TODO: Implementirati: svi kvizovi u aplikaciji
            return kvizes()
        }

        fun getDone(): List<Kviz>{
            return doneKvizes()
        }

        fun getMyDoneKvizes(): List<Kviz> {
            // TODO: Implementirati: moji kvizovi koji su uradjeni
            return myDoneKvizes()
        }

        fun getFuture(): List<Kviz>{
            return futureKvizes()
        }

        fun getMyFutureKvizes(): List<Kviz> {
            // TODO: Implementirati: moji kvizovi koji su budući
            return myFutureKvizes()
        }

        fun getNotTaken(): List<Kviz>{
            return notTakenKvizes()
        }

        fun getMyNotTakenKvizes(): List<Kviz> {
            // TODO: Implementirati: moji kvizovi koji su prošli ali nisu urađeni
            return myNotTakenKvizes()
        }

        // TODO: Implementirati i ostale potrebne metode

*/
       suspend fun getAll(): List<Kviz>? {
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getSviKvizovi()
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }

        suspend fun getById(id: Int): Kviz? {
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getKvizByID(id)
                val responseBody = response.execute().body()
                //println(responseBody)
                return@withContext responseBody
            }
            return null;
        }

        suspend fun getUpisani(): List<Kviz>? {
            val upisaneGrupe = PredmetIGrupaRepository.getUpisaneGrupe();
            if (upisaneGrupe != null) {
                println(upisaneGrupe.size)
            }
            var kvizovi : List<Kviz>?
            kvizovi = emptyList()
            if (upisaneGrupe != null) {
                for(x in upisaneGrupe){
                    var response = ApiAdapter.retrofit.kvizoviByGrupaId(x.id)
                    val responseBody = response.clone().execute().body()
                    val listaKvizova = responseBody
                    if(listaKvizova != null){
                        for(y in listaKvizova) kvizovi += y;
                    }
                }
            }
            return kvizovi;
        }
    }

}