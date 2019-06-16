package com.grosalex.nasaapi

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.grosalex.nasaapi.activity.DetailActivity
import com.grosalex.nasaapi.activity.HDActivity
import com.grosalex.nasaapi.model.Apod

object Navigator {
    fun openDetail(context: Context, apod: Apod){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DETAIL_KEY, Gson().toJson(apod))
        context.startActivity(intent)
    }

    fun openHD(context: Context, apod: Apod) {
        val intent = Intent(context, HDActivity::class.java)
        intent.putExtra(URL_KEY,apod.hdurl)
        context.startActivity(intent)
    }

    const val DETAIL_KEY = "detail_key"
    const val URL_KEY = "url_key"
}