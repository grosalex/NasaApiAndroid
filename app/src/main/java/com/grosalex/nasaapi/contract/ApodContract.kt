package com.grosalex.nasaapi.contract

import com.grosalex.nasaapi.model.Apod

interface ApodContract {
    interface View{
        fun load()
        fun add(apod: Apod)
        fun onError(message: String)
    }

    interface Presenter{
        fun loadThirtyDays()
        fun shouldLoadNext(date: String):Boolean
    }

    interface Provider{
        interface OnProvide{
            fun onSuccess(apod: Apod)
            fun onFailure(message:String)
        }
        fun getApod(date:String, onProvide: OnProvide)
    }
}