package com.example.abschlussappbenji.Datenbank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.DatenKlassen.DatenTabelle

const val TAG = "RepositoryTAG"

class Repository (val teamApi: TeamApi) {

    private val _currentteams = MutableLiveData<List<DatenTabelle>>()

    val teams: LiveData<List<DatenTabelle>>
        get() = _currentteams

    suspend fun getTeams() {

        try {
            val newTeam = teamApi.apiService.getTeam()
            _currentteams.postValue(newTeam)
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Data from Api: $e")
        }
    }
}