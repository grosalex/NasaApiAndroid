package com.grosalex.nasaapi.provider

import com.grosalex.nasaapi.NasaApiApp
import com.grosalex.nasaapi.api.ApiCallback
import com.grosalex.nasaapi.contract.ApodContract
import com.grosalex.nasaapi.model.Apod

class ApodProvider : ApodContract.Provider {
    override fun getApod(date: String, onProvide: ApodContract.Provider.OnProvide) {
        NasaApiApp.get().service.apod(date).enqueue(object : ApiCallback<Apod>() {
            override fun onSuccess(body: Apod?) {
                if (body != null) {
                    onProvide.onSuccess(body)
                }
            }

            override fun onAnyError(error: String) {
                onProvide.onFailure(error)
            }
        })
    }
}