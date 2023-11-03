package com.example.abschlussappbenji.UI

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.Datenbank.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfosViewModel : ViewModel() {

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