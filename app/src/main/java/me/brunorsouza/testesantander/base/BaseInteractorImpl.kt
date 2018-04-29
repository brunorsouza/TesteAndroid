package me.brunorsouza.testesantander.base

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import me.brunorsouza.testesantander.webservice.Deserializer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by brunosouza.
 */

open class BaseInteractorImpl {

    private var retrofit: Retrofit? = null

    fun createAPI(domain: String, apiClass: Class<*>): Any {
        val gson = GsonBuilder().registerTypeAdapter(Deserializer::class.java, Deserializer()).create()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(httpLoggingInterceptor)

        retrofit = Retrofit.Builder().baseUrl(domain).client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

        return retrofit!!.create(apiClass)

    }

    fun convetJsonToObjct(json: String, clazz: Class<*>): Any? {

        if (json == null)
            return null

        val gson = Gson()
        val fromJson = gson.fromJson(json, clazz)

        return fromJson
    }


    fun convetJsonToObjct(array: JsonArray, clazz: Class<*>): List<Any> {
        val gson = Gson()
        val listT = ArrayList<Any>()
        for (i in 0 until array.size()) {
            val fromJson = gson.fromJson(array.get(i), clazz)
            listT.add(fromJson)
        }
        return listT
    }

}