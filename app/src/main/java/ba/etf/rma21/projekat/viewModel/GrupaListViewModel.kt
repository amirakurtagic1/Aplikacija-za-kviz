package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.GrupaRepository
import ba.etf.rma21.projekat.data.repositories.PredmetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GrupaListViewModel() {

    suspend fun getGroups(): List<Grupa>? {
        return withContext(Dispatchers.IO) {
            return@withContext GrupaRepository.getGroups()
        }
    }

    suspend fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa>? {
        return withContext(Dispatchers.IO) {
           return@withContext GrupaRepository.getGroupsByPredmet(nazivPredmeta)
        }
    }
}