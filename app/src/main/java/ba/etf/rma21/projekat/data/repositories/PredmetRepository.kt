package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PredmetRepository {
    companion object {

        lateinit var predmet:Predmet
         var noviPredmetiLista = emptyList<Predmet>()

        fun addPredmetToUpisani(predmet: Predmet){
            this.predmet = predmet;
            noviPredmetiLista += predmet;
        }
        fun getUpisani(): List<Predmet> {
            var getUpisani: List<Predmet>  = upisani()
            if(this::predmet.isInitialized) {
                getUpisani += noviPredmetiLista;
            }
            return getUpisani
        }

        suspend fun getAll(
        ) : List<Predmet>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getAllPredmets()
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }

        fun getPredmetsByGodina(godina: Int): List<Predmet>{
            return predmetiByGodina(godina)
        }
        // TODO: Implementirati i ostale potrebne metode
    }

}