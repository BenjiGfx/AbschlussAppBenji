package com.example.abschlussappbenji.Datenbank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.DatenKlassen.SpData

const val SPTAG = "Spielplan_RepositoryTAG"

class Spielplan_Repository(val SpielplanTeamApi: TeamApi){

    private val _currentspielplandata = MutableLiveData<List<SpData>>()
    val spdata: LiveData<List<SpData>>
        get() = _currentspielplandata


    suspend fun getSpData() {

        try {
            val newSpTeam = SpielplanTeamApi.apiService.getSpData()
            _currentspielplandata.postValue(newSpTeam)
        } catch (e:Exception) {
            Log.e(SPTAG, "Error loading Data from API: $e")
        }
    }
}