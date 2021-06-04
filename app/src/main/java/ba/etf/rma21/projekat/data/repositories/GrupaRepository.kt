package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.groups
import ba.etf.rma21.projekat.data.models.groupsByPredmet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GrupaRepository {
    companion object {
        init {

        }

        suspend fun getGroups(): List<Grupa>? {
            return withContext(Dispatchers.IO) {
               var response = ApiAdapter.retrofit.getAllGroups()
                var responseBody = response.execute().body()
                return@withContext responseBody
            }
        }


        suspend fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa>? {
            return withContext(Dispatchers.IO) {
                var listOfAllPredmets = PredmetRepository.getAll()
                var id: Int?
                id = 0;
                if (listOfAllPredmets != null) {
                    for(x in listOfAllPredmets){
                        if(x.naziv.equals(nazivPredmeta)) id = x.id
                    }
                }
                var response = ApiAdapter.retrofit.grupeByPredmetId(id!!)
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }
    }
}