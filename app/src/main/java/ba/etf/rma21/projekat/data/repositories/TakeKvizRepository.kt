package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.KvizTaken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TakeKvizRepository {
    companion object{
       suspend fun zapocniKviz(idKviza:Int): KvizTaken? {
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.odgovaranjestudentaPOSTSaIdNaKvizuById(AccountRepository.getHash(), idKviza)
                var responseBody = response.clone().execute().body()
                if(responseBody != null)  return@withContext responseBody
                return@withContext null;
            }
        }

        suspend fun getPocetiKvizovi():List<KvizTaken>?{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.listaPokusajaZaStudentByID(AccountRepository.getHash())
                var responseBody = response.clone().execute().body()
                if (responseBody != null) {
                    if(response.execute().isSuccessful && !responseBody.size.equals(0))  return@withContext responseBody
                }
                return@withContext null;
            }
        }

    }
}