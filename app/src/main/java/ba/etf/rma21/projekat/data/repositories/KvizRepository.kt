package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.*

class KvizRepository {

    companion object {
        // TODO: Implementirati
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
    }
}