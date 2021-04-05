package ba.etf.rma21.projekat.data.models

import ba.etf.rma21.projekat.data.repositories.PredmetRepository

fun predmeti(): List<Predmet>{
    return listOf(Predmet("RMA", 2),
                  Predmet("OIS",2),
                  Predmet("TP",1),
                  Predmet("UUP", 1),
                  Predmet("RS", 1),
                  Predmet("FWT", 1),
                  Predmet("RP", 1),
                  Predmet("PJP", 2),
                  Predmet("ASP", 2),
                  Predmet("NRS",2),
            //treća godina na smjeru RS
                  Predmet("IM1", 3),
                  Predmet("IM2", 3),
                  Predmet("MLTI", 3))
}


fun upisani(): List<Predmet>{
    return listOf(Predmet("RMA",2), Predmet("UUP", 1), Predmet("NRS", 2));
}

fun predmetiByGodina(godina: Int): List<Predmet>{
    var predmetiPoGodini: List<Predmet> = emptyList<Predmet>()
    var sviPredmeti: List<Predmet> = predmeti()
    for(predmet in sviPredmeti) if(predmet.godina.equals(godina)){
       // println("Dosao sam ovdje!")
        predmetiPoGodini += predmet
    }
    return predmetiPoGodini
}