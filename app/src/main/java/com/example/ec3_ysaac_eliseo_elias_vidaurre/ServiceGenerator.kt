package com.example.ec3_ysaac_eliseo_elias_vidaurre
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val client = OkHttpClient.Builder().build()
    private val retrofit =Retrofit.Builder()
        .baseUrl("https://62db5de7e56f6d82a771fb31.mockapi.io")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> buildService(serviceClass: Class<T>):T{
        return retrofit.create(serviceClass)
    }

}