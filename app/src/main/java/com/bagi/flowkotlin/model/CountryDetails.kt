package com.bagi.flowkotlin.model

data class CountryDetails(
    val active: Int,
    val cases: Int,
    val casesPerOneMillion: Int,
    val country: String,
    val countryInfo: CountryInfo,
    val critical: Int,
    val deaths: Int,
    val deathsPerOneMillion: Int,
    val recovered: Int,
    val tests: Int,
    val testsPerOneMillion: Int,
    val todayCases: Int,
    val todayDeaths: Int,
    val updated: Long
)