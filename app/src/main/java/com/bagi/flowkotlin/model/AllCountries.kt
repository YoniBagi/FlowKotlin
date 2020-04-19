package com.bagi.flowkotlin.model

data class AllCountries(
    val active: Int,
    val affectedCountries: Int,
    val cases: Int,
    val casesPerOneMillion: Int,
    val critical: Int,
    val deaths: Int,
    val deathsPerOneMillion: Int,
    val recovered: Int,
    val tests: Int,
    val testsPerOneMillion: Double,
    val todayCases: Int,
    val todayDeaths: Int,
    val updated: Long
)