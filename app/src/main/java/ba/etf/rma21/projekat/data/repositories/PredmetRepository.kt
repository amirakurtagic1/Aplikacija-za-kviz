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
        suspend fun getUpisani(): List<Predmet>? {

            return withContext(Dispatchers.IO) {
                var listaSvihPredmeta = getAll()
                var listOfUpisaniPredmet: List<Predmet>?
                listOfUpisaniPredmet = emptyList()
                var response = ApiAdapter.retrofit.getUpisaneGrupe(AccountRepository.getHash())
                val responseBody = response.execute().body()
                if(responseBody !== null){
                    for(x in responseBody){
                        if (listaSvihPredmeta != null) {
                            for(y in listaSvihPredmeta){
                                if(x.PredmetId.equals(y.id)) listOfUpisaniPredmet += y
                            }

                        }
                    }
                }
                return@withContext listOfUpisaniPredmet
            }
           // var getUpisani: List<Predmet>  = upisani()
           // if(this::predmet.isInitialized) {
            //    getUpisani += noviPredmetiLista;
           // }
           // return getUpisani
        }

        suspend fun getAll(
        ) : List<Predmet>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getAllPredmets()
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }

        suspend fun getPredmetsByGodina(godina: Int): List<Predmet>{
            return withContext(Dispatchers.IO) {
                var response = getAll()
                var listaPredmetaByGodina: List<Predmet>?
                listaPredmetaByGodina = emptyList()
                if (response != null) {
                    for(x in response){
                        if(x.godina.equals(godina)) listaPredmetaByGodina += x;
                    }
                }
                return@withContext listaPredmetaByGodina
            }
        }
        // TODO: Implementirati i ostale potrebne metode
    }

}