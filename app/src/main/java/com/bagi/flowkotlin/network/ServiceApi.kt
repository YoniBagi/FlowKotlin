package com.bagi.flowkotlin.network

import com.bagi.flowkotlin.model.CountryDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {
    @GET("v2/countries/{country}")
    suspend fun getCountryDetails(@Path("country") country: String, @Query("yesterday") untilYesterday: Boolean) : CountryDetails
}