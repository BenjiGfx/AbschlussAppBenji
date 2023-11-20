package com.example.abschlussappbenji.UI

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussappbenji.ApiSteuerung.TeamApi
import com.example.abschlussappbenji.Datenbank.Repository
import com.example.abschlussappbenji.Datenbank.getDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Die Logik für das Infos-Fragment
class InfosViewModel(app: Application) : AndroidViewModel(app){

    val database = getDatabase(app)
    val repository = Repository(TeamApi, database)
    val team = repository.teams

    init {
        loadTeam()
    }

    //Beim Abruf dieser Funktion wird die Funktion im Repository aufgerufen.
    fun loadTeam() {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getTeams()
        }
    }
}