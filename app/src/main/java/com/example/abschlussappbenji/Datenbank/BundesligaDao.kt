package com.example.abschlussappbenji.Datenbank

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.abschlussappbenji.DatenKlassen.DatenTabelle


@Dao
interface BundesligaDao {

    //Holt die Daten aus der Datenbank
@Query(" SELECT * FROM DatenTabelle")
fun getAllTableData(): LiveData<List<DatenTabelle>>


//Speichert die Daten in die Datenbank
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTableData(tabledata: List<DatenTabelle>)
}