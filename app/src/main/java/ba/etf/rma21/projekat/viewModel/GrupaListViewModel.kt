package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.repositories.GrupaRepository

class GrupaListViewModel() {

    fun getGroups(): List<Grupa> {
        return GrupaRepository.getGroups()
    }

    fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa> {
        return GrupaRepository.getGroupsByPredmet(nazivPredmeta)
    }
}