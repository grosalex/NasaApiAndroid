package com.grosalex.nasaapi.api

import com.grosalex.nasaapi.model.Apod
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {

    @GET("planetary/apod?api_key=CDdhDJpp1uGBad5YbBgJNN1AR0DLXSDlDzoVO6AS")
    fun apod(@Query("date") date: String): Call<Apod>

    companion object {
        const val ROOT = "https://api.nasa.gov/"
    }
}