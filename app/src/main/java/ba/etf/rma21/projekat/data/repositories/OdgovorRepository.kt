package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.ApiAdapter
import ba.etf.rma21.projekat.data.models.Odgovor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OdgovorRepository {

    companion object{
       suspend fun getOdgovoriKviz(idKviza:Int):List<Odgovor>?{
           return withContext(Dispatchers.IO) {
               var response = ApiAdapter.retrofit.listaOdgovoraByKvizIdIStudentId(AccountRepository.getHash(), idKviza)
               var responseBody = response.clone().execute().body()
               println(responseBody)
               if(responseBody != null)  return@withContext responseBody
               return@withContext emptyList();
           }
        }

        //postaviOdgovorKviz(idKvizTaken:Int,idPitanje:Int,odgovor:Int):Int - funkcija postavlja
        //odgovor sa indeksom odgovor na pitanje sa id-em idPitanje u okviru pokušaja sa id-em
        //idKvizTaken. Funkcija vraća ukupne bodove na kvizu nakon odgovora ili -1 ukoliko ima
        //neka greška u zahtjevu
        suspend fun postaviOdgovorKviz(idKvizTaken:Int,idPitanje:Int,odgovor:Int):Int{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.odgovorZaKvizKtidStudentHash(AccountRepository.getHash(), idKvizTaken, idPitanje, odgovor, 50)
                println(response.clone().execute().message())
                if(response.execute().isSuccessful) return@withContext 50;
                else return@withContext -1;
            }
        }


    }
}