package cat.api.testapi.api

import cat.api.testapi.common.AuthorData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiActions {

    @Headers("Content-Type: application/json")
    @POST("autores")
    fun addAutor(@Body authorData: AuthorData): Call<AuthorData>

    @GET("autores")
    fun getAllAuthors(): Response<List<AuthorData>>

}