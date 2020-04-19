package com.bagi.flowkotlin.activity.covid19

import com.bagi.flowkotlin.model.CountryDetails
import com.bagi.flowkotlin.network.RetrofitManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Covid19ActivityModel {

    fun getCountryDetails() : Flow<CountryDetails>{
        return flow{
            emit(RetrofitManager.instanceServiceApi.getCountryDetails("israel", false))
        }
    }
}