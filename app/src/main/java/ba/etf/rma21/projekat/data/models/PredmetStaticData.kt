package ba.etf.rma21.projekat.data.models

import ba.etf.rma21.projekat.data.repositories.PredmetRepository

fun predmeti(): List<Predmet>{
    return emptyList();

}


fun upisani(): List<Predmet>{
    return emptyList();
}

fun predmetiByGodina(godina: Int): List<Predmet>{
    var predmetiPoGodini: List<Predmet> = emptyList<Predmet>()
    var sviPredmeti: List<Predmet> = predmeti()
    for(predmet in sviPredmeti) if(predmet.godina.equals(godina)){
        predmetiPoGodini += predmet
    }
    return predmetiPoGodini
}