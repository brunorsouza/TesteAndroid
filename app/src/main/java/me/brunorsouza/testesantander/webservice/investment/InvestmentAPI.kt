package me.brunorsouza.testesantander.webservice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by brunosouza.
 */
interface InvestmentAPI {

    @Headers("Accept: application/json")
    @GET("fund.json")
    fun getFund(): Call<InvestmentResponse>

}