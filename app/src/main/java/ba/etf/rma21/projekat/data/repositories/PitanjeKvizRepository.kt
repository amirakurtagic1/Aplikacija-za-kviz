package ba.etf.rma21.projekat.data.repositories

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
         suspend fun getPitanja(idKviza: Int):List<Pitanje> {
             val baseURL: String = ApiConfig.baseURL;
             val url = URL("$baseURL/kviz/$idKviza/pitanja");
             (url.openConnection() as? HttpURLConnection)?.run {
                 val responseCode = this.responseCode
                 val result = this.inputStream.bufferedReader().use { it.readText() }
                 val json = JSONObject(result)//5
                 println("Da znas da sam ovdje  " +  json)
             }

            return emptyList();
        }
    }

}