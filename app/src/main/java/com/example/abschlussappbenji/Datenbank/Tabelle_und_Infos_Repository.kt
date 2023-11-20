package com.example.abschlussappbenji.Datenbank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.DatenKlassen.DatenTabelle

const val TAG = "RepositoryTAG"

class Repository (val teamApi: TeamApi, val database: BundesligaDatabase) {

    val teams: LiveData<List<DatenTabelle>> = database.dao.getAllTableData()

    suspend fun getTeams() {

        try {
            val newTeam = teamApi.apiService.getTeam()
            database.dao.insertTableData(newTeam)
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Data from Api: $e")
        }
    }
}