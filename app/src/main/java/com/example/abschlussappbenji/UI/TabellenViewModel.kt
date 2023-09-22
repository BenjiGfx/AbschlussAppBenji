package com.example.abschlussappbenji.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.Datenbank.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TabellenViewModel: ViewModel() {

    val repository = Repository(TeamApi)
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