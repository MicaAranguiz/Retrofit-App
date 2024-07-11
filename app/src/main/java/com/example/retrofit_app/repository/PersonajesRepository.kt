package com.example.retrofit_app.repository

import com.example.retrofit_app.api.PersonajesApi
import com.example.retrofit_app.model.ListaPersonajes
import javax.inject.Inject

class PersonajesRepository @Inject constructor(
    private val personajesApi: PersonajesApi
) {
    suspend fun getPersonajes(): ListaPersonajes {
        return personajesApi.getPersonajes()
    }
}