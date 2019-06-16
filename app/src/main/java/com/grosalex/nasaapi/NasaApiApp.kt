package com.grosalex.nasaapi

import android.app.Application
import com.grosalex.nasaapi.api.NasaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaApiApp : Application(){
    lateinit var service:NasaService
    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(NasaService.ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<NasaService>(NasaService::class.java)
        app = this
    }

    companion object{
        lateinit var app:NasaApiApp
        fun get():NasaApiApp{
            return app
        }
    }
}