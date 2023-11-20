package com.example.abschlussappbenji.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.Datenbank.BundesligaDatabase
import com.example.abschlussappbenji.Datenbank.Repository
import com.example.abschlussappbenji.Datenbank.getDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TabellenViewModel(app: Application) : AndroidViewModel(app) {

    val database = getDatabase(app)
    val repository = Repository(TeamApi, database)
    val team = repository.teams

    init {
        loadTeam()
    }

    fun loadTeam() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTeams()
        }
    }
}