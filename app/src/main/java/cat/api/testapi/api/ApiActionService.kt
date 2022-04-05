package cat.api.testapi.api

import cat.api.testapi.common.AuthorData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiActionService {
    fun addAutor(authorData: AuthorData, onResult: (AuthorData?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiActions::class.java)
        retrofit.addAutor(authorData).enqueue(
            object : Callback<AuthorData> {
                override fun onFailure(call: Call<AuthorData>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<AuthorData>, response: Response<AuthorData>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
    fun getAutors(authorData: AuthorData, onResult: (List<AuthorData?>) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiActions::class.java)
        retrofit.getAllAuthors()(
            object : Callback<AuthorData> {
                override fun onFailure(call: Call<AuthorData>, t: Throwable) {
                    onResult(emptyList())
                }
                override fun onResponse(call: Call<AuthorData>, response: Response<AuthorData>) {
                    val allAuthors = response.body()
                    onResult(allAuthors)
                }
            }
        )
    }
}