package com.example.retrofit_app.api

import com.example.retrofit_app.model.ListaPersonajes
import retrofit2.http.GET

interface PersonajesApi {
    @GET("character")
    suspend fun getPersonajes(): ListaPersonajes
}