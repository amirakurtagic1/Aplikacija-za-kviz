package ba.etf.rma21.projekat.data.models

import ba.etf.rma21.projekat.data.repositories.GrupaRepository

fun getGroups(): List<Grupa>{
    return GrupaRepository.getGroups()
}


fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa> {
    return GrupaRepository.getGroupsByPredmet(nazivPredmeta)
}