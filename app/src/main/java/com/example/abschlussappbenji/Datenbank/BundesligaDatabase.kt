package com.example.abschlussappbenji.Datenbank

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abschlussappbenji.DatenKlassen.DatenTabelle

@Database(entities = [DatenTabelle::class], version = 1)
abstract class BundesligaDatabase : RoomDatabase() {

    abstract val dao: BundesligaDao
}

private lateinit var INSTANCE: BundesligaDatabase

fun getDatabase(context: Context): BundesligaDatabase {

    synchronized(BundesligaDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {


            //Neue Datenbank Instanz erstellen
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                BundesligaDatabase::class.java,
                "bundesliga_database"
            )
                .build()
        }

        return INSTANCE
    }
}