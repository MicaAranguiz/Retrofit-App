package com.example.retrofit_app.di

import com.example.retrofit_app.api.PersonajesApi
import com.example.retrofit_app.utils.Constants.BASE_URL
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): PersonajesApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PersonajesApi::class.java)
    }
}