package ba.etf.rma21.projekat.data.models

import ba.etf.rma21.projekat.BuildConfig
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("predmet")
     fun getAllPredmets(): Call<List<Predmet>>

    @GET("grupa")
    fun getAllGroups(): Call<List<Grupa>>

    @GET("predmet/{id}")
    fun getPredmetById(@Path("id") id: Int): Call<Predmet>

    @GET("/student/{id}/grupa")
    fun getUpisaneGrupe(@Path("id") id: String): Call<List<Grupa>>
}