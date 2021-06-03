package ba.etf.rma21.projekat.data.repositories

import android.widget.Toast
import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.security.AccessController.getContext


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

        suspend fun getGrupeZaPredmet(idPredmeta:Int):List<Grupa>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.grupeByPredmetId(idPredmeta)
                val responseBody = response.execute().body()
                return@withContext responseBody
            }
        }
        suspend fun upisiUGrupu(idGrupa:Int):Boolean{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.dodajStudentaSaHashomUGrupuSaId(idGrupa, AccountRepository.getHash())
                if(response.clone().execute().isSuccessful) return@withContext true;
                return@withContext false
            }
            return true;
        }
        suspend fun getUpisaneGrupe():List<Grupa>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.getUpisaneGrupe(AccountRepository.getHash())
                val responseBody = response.clone().execute().body()
                if(response.execute().isSuccessful) return@withContext  responseBody
                return@withContext null
            }
        }
    }
}