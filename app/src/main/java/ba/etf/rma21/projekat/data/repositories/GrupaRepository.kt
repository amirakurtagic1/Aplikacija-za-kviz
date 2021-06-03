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

        fun getGroups(): List<Grupa>{
            return groups()
        }


        fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa> {
           /* return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.grupeByPredmetId()
                val responseBody = response.execute().body()
                return@withContext responseBody
            }*/
            return emptyList()
        }
    }
}