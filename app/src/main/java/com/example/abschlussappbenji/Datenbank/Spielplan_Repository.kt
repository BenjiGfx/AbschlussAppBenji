package com.example.abschlussappbenji.Datenbank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.DatenKlassen.SpData

const val SPTAG = "Spielplan_RepositoryTAG" // Hier wird eine Konstante deklariert.

class Spielplan_Repository(val SpielplanTeamApi: TeamApi){ // Hier wird eine Klase definiert, die in ihrem Konstruktor einen Parameter akzeptiert.

    // Hier wird eine private Live-Data-Konstante initialisiert und stellt sie zur Verfügung.
    private val _currentspielplandata = MutableLiveData<List<SpData>>()
    val spdata: LiveData<List<SpData>>
        get() = _currentspielplandata //Hier hole ich mir die Werte der privaten Konstante.


    // Hier werden die Daten der API abgerufen und übergibt diese an die MutableLiveData.
    suspend fun getSpData() {

        try {
            val newSpTeam = SpielplanTeamApi.apiService.getSpData()
            _currentspielplandata.postValue(newSpTeam)
        } catch (e:Exception) {
            Log.e(SPTAG, "Error loading Data from API: $e")
        }
    }
}