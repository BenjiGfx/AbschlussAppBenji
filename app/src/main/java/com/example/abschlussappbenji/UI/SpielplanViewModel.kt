package com.example.abschlussappbenji.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.Datenbank.Spielplan_Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpielplanViewModel: ViewModel() {

    val spielplanrepository = Spielplan_Repository(TeamApi)
    val spielplanteam = spielplanrepository.spdata  // teams ist die constante im Repository.

    init {
        loadTeam()
    }

    fun loadTeam() {

        viewModelScope.launch(Dispatchers.IO) {
            spielplanrepository.getSpData()
        }
    }
}