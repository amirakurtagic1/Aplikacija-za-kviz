package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.Pitanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class PitanjeKvizRepository {
    companion object {
         suspend fun getPitanja(idKviza: Int):List<Pitanje>? {
             return withContext(Dispatchers.IO) {
                 var response = ApiAdapter.retrofit.pitanjaNaKvizuById(idKviza)
                 val responseBody = response.clone().execute().body()
                 return@withContext responseBody
             }
        }
    }

}