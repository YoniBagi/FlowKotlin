package com.bagi.flowkotlin.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager private constructor(){
    companion object {
        private const val BASE_URL = "https://corona.lmao.ninja/"

        val instanceServiceApi : ServiceApi by lazy {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            retrofit.create(ServiceApi::class.java)
        }
    }
}