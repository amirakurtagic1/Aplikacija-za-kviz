package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.AccountRepository
import ba.etf.rma21.projekat.data.repositories.PredmetIGrupaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PredmetiIGrupeListViewModel {
    suspend fun getPredmeti():List<Predmet>?{
        return withContext(Dispatchers.IO) {
            return@withContext PredmetIGrupaRepository.getPredmeti()
        }
    }
    suspend fun getGrupe():List<Grupa>?{
        return withContext(Dispatchers.IO) {
            return@withContext PredmetIGrupaRepository.getGrupe()
        }
    }

    suspend fun getGrupeZaPredmet(idPredmeta:Int):List<Grupa>?{
        return withContext(Dispatchers.IO) {
            return@withContext PredmetIGrupaRepository.getGrupeZaPredmet(idPredmeta)
        }
    }
    suspend fun upisiUGrupu(idGrupa:Int):Boolean{
        return withContext(Dispatchers.IO) {
            return@withContext PredmetIGrupaRepository.upisiUGrupu(idGrupa)
        }
        return true;
    }
    suspend fun getUpisaneGrupe():List<Grupa>?{
        return withContext(Dispatchers.IO) {
            return@withContext PredmetIGrupaRepository.getUpisaneGrupe()
        }
    }
}
