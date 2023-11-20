package com.example.abschlussappbenji.DatenKlassen

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatenTabelle(

    @PrimaryKey()
    val teamInfoId: Int,

    val teamName: String,
    val teamIconUrl: String,
    val points: Int,
    val goals: Int,
    val matches: Int,
    val won: Int,
    val lost: Int,
    val draw: Int,
    val goalDiff: Int
)
