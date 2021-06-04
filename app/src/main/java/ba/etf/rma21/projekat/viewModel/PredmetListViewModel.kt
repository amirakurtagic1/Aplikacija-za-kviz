package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.data.repositories.PredmetRepository
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class PredmetListViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    fun addPredmetToUpisani(predmet: Predmet){
        return PredmetRepository.addPredmetToUpisani(predmet)
    }

    suspend fun getUpisani(): List<Predmet>? {
        return withContext(Dispatchers.IO){
            return@withContext PredmetRepository.getUpisani()
        }
    }

    suspend fun getAll(): List<Predmet>? {
       return PredmetRepository.getAll()
    }

    suspend fun getPredmetsByGodina(godina: Int): List<Predmet>? {
        return withContext(Dispatchers.IO){
            var result = PredmetRepository.getPredmetsByGodina(godina)
            return@withContext result
        }
    }
}