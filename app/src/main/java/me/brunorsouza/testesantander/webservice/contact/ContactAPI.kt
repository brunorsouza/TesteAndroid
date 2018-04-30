package me.brunorsouza.testesantander.webservice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by brunosouza.
 */
interface ContactAPI {

    @Headers("Accept: application/json")
    @GET("cells.json")
    fun getCells(): Call<CellResponse>

}