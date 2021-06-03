package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.ApiAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AccountRepository {

    companion object {
        //TODO Ovdje trebate dodati hash string vašeg accounta
        var acHash: String = "e9336960-63fd-4158-af6a-a7a2b2984288"

        fun postaviHash(acHash: String): Boolean {
            this.acHash = acHash
            return true
        }

        fun getHash(): String {
            return acHash
        }

        suspend fun obrisiSveOdKorisnika(): Boolean{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.obrisiSvePodatkePovezaneSaKorisnikom(acHash)
                val responseBody = response?.body()
                println(responseBody)
                return@withContext true
            }
        }

    }
}