package com.example.abschlussappbenji.ApiSteuerung

import com.example.abschlussappbenji.DatenKlassen.DatenTabelle
import com.example.abschlussappbenji.DatenKlassen.SpData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.openligadb.de/"

// Durch "moshi" wird die Json konvertiert.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit erleichtert die Android-Anwendungen von HTTP-Anfragen.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


// Die Definition von einzelnen HTTP-Anfragen.
interface TeamApiService {

    @GET("getbltable/bl1/2023")
    suspend fun getTeam(): List<DatenTabelle>

    @GET("getmatchdata/bl1/2023")
    suspend fun getSpData(): List<SpData>

}

//Hier wird von retrofit ein Objekt erstellt und mit den HTTP-Anfragen gekoppelt.
object TeamApi {

    val apiService: TeamApiService by lazy { retrofit.create(TeamApiService::class.java)}
}