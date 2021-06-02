package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Account
import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PredmetIGrupaRepository {

    companion object{

        suspend fun getPredmeti():List<Predmet>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getAllPredmets()
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }
        suspend fun getGrupe():List<Grupa>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getAllGroups()
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }

        fun getGrupeZaPredmet(idPredmeta:Int):List<Grupa>{
            return listOf();
        }
        fun upisiUGrupu(idGrupa:Int):Boolean{

            return true;
        }
        suspend fun getUpisaneGrupe():List<Grupa>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getUpisaneGrupe(AccountRepository.getHash())
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }
    }
}