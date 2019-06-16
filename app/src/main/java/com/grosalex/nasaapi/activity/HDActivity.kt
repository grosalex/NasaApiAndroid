package com.grosalex.nasaapi.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.grosalex.nasaapi.Navigator
import com.grosalex.nasaapi.R
import com.squareup.picasso.Picasso

class HDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hd)
        val url = intent.getStringExtra(Navigator.URL_KEY)
        val ivHD:ImageView = findViewById(R.id.iv_hd)
        Picasso.get().load(url).into(ivHD)
    }
}