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
        return withContext(Dispatchers.IO) {
            return@withContext PredmetRepository.getAll()
        }
    }

    suspend fun getMaxId(): Int{
        return withContext(Dispatchers.IO){
            var id: Int
            id = 1;
            var listaPredmeta = getAll()
            if (listaPredmeta != null) {
                for (x in listaPredmeta){
                    if(x.id > id) id = x.id;
                }
            }
            if(id == 1) return@withContext id;
            else return@withContext id+1;
        }
    }

    suspend fun getPredmetsByGodina(godina: Int): List<Predmet>? {
        return withContext(Dispatchers.IO){
            var result = PredmetRepository.getPredmetsByGodina(godina)
            return@withContext result
        }
    }
}