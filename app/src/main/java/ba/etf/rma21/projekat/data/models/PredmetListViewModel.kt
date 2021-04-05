package ba.etf.rma21.projekat.data.models

import ba.etf.rma21.projekat.data.repositories.PredmetRepository

fun getUpisani(): List<Predmet> {
    return PredmetRepository.getUpisani()
}

fun getAll(): List<Predmet> {
    return PredmetRepository.getAll()
}

fun getPredmetsByGodina(godina: Int): List<Predmet>{
    return PredmetRepository.getPredmetsByGodina(godina)
}