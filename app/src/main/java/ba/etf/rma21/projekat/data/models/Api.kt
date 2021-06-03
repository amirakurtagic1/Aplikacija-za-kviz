package ba.etf.rma21.projekat.data.models

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface Api {

    //Predmet
    @GET("predmet")
     fun getAllPredmets(): Call<List<Predmet>>

    @GET("predmet/{id}")
    fun getPredmetById(@Path("id") id: Int): Call<Predmet>

    //Grupa
    @GET("grupa")
    fun getAllGroups(): Call<List<Grupa>>

    @GET("kviz/{id}/grupa")
    fun grupeZaDostupniKviz(@Path("id") id: Int): Call<List<Grupa>>

    @POST("grupa/{gid}/student/{id}")
    fun dodajStudentaSaHashomUGrupuSaId(@Path("gid") gid: Int, @Path("id") id: String): Call<JSONObject>

    @GET("student/{id}/grupa")
    fun getUpisaneGrupe(@Path("id") id: String): Call<List<Grupa>>

    @GET("grupa/{id}")
    fun grupaById(@Path("id") id: Int): Call<Grupa>

    @GET("predmet/{id}/grupa")
    fun grupeByPredmetId(@Path("id") id: Int) : Call<List<Grupa>>

    //Kviz
    @GET("kviz")
    fun getSviKvizovi(): Call<List<Kviz>>

    @GET("kviz/{id}")
    fun getKvizByID(@Path("id") id: Int) : Call<Kviz>

    @GET("grupa/{id}/kvizovi")
    fun kvizoviByGrupaId(@Path("id") id: Int) : Call<List<Kviz>>

    //Odgovor
    @GET("student/{id}/kviztaken/{ktid}/odgovori")
    fun listaOdgovoraByKvizIdIStudentId(@Path("id") id: String, @Path("ktid") ktid: Int): Call<List<Odgovor>>

    //Dodaje odgovor za pokušaja rješavanja kviza sa id-em ktid i za studenta sa zadanim hash id-em
    @FormUrlEncoded
    @POST("student/{id}/kviztaken/{ktid}/odgovor")
    fun odgovorZaKvizKtidStudentHash(@Path("id") id: String, @Path("ktid") ktid: Int,
                                     @Field("odgovor") odgovor: Int,
                                     @Field("pitanje") pitanje: Int,
                                     @Field("bodovi") bodovi:Int): Call<Odgovor>


    //KvizTaken
    @GET("/student/{id}/kviztaken")
    fun listaPokusajaZaStudentByID(@Path("id") id: String): Call<List<KvizTaken>>

    //Započinje odgovaranje studenta sa id-jem id na kvizu sa id-em kid
    @POST("student/{id}/kviz/{kid}")
    fun odgovaranjestudentaPOSTSaIdNaKvizuById(@Path("id") id: String, @Path("kid") kid: Int): Call<KvizTaken>

    //Account
    @GET("student/{id}")
    fun accountStudentaById(@Path("id") id: String): Call<Account>

    @DELETE("student/{id}/upisugrupeipokusaji")
    fun obrisiSvePodatkePovezaneSaKorisnikom(@Path("id") id: String): Response<*>?

    //Pitanje
    @GET("kviz/{id}/pitanja")
    fun pitanjaNaKvizuById(@Path("id") id: Int) : Call<List<Pitanje>>



}