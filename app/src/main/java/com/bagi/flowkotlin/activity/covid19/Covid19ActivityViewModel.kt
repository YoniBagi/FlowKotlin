package com.bagi.flowkotlin.activity.covid19

import android.util.Log
import androidx.lifecycle.*
import com.bagi.flowkotlin.R
import com.bagi.flowkotlin.model.CountryDetails
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class Covid19ActivityViewModel : ViewModel() {
    private val countryDetailsMLD = MutableLiveData<MutableList<Triple<Int, Int?, Int?>>>()
    private val progressDataMLD = MutableLiveData<Boolean>()
    private val updatedMLd = MutableLiveData<String>()

    fun getCountryDetailsMLD(): LiveData<MutableList<Triple<Int, Int?, Int?>>> = countryDetailsMLD
    fun getProgressDataMLD(): LiveData<Boolean> = progressDataMLD
    fun getUpdatedMLd(): LiveData<String> = updatedMLd


    fun getCountryData(){
        viewModelScope.launch {
            val countryDetails = Covid19ActivityModel.getCountryDetails()
                    .onStart { progressDataMLD.value = true }
                    .onCompletion { progressDataMLD.value = false }
                    .catch { Log.e("${Covid19ActivityViewModel::class.java.name}: getCountryData()",
                        "Error fetch data") }
                    .singleOrNull()
            countryDetailsMLD.value = getListFRomObject(countryDetails)
            updatedMLd.value = convertLongToTime(countryDetails?.updated)
        }
    }

    private fun convertLongToTime(time: Long?): String {
        time?.let {
            val sdf = SimpleDateFormat("dd.MM.yy HH:mm", Locale.US)
            return sdf.format(Date(time))
        }
        return ""
    }

    private fun getListFRomObject(countryDetails: CountryDetails?): MutableList<Triple<Int, Int?, Int?>> {
        val listDetails = mutableListOf<Triple<Int, Int?, Int?>>()
        listDetails.apply {
            add(Triple(R.string.cases, countryDetails?.cases, R.color.red))
            add(Triple(R.string.active, countryDetails?.active,null))
            add(Triple(R.string.critical, countryDetails?.critical,null))
            add(Triple(R.string.recovered, countryDetails?.recovered,null))
            add(Triple(R.string.tests, countryDetails?.tests,null))
            add(Triple(R.string.today_deaths, countryDetails?.todayDeaths,null))
            add(Triple(R.string.deaths, countryDetails?.deaths, R.color.green))
        }
        return listDetails
    }
}