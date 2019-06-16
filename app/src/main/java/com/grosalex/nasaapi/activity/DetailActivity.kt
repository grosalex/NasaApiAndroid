package com.grosalex.nasaapi.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.gson.Gson
import com.grosalex.nasaapi.Navigator
import com.grosalex.nasaapi.R
import com.grosalex.nasaapi.model.Apod
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private var apod: Apod? = null

    private lateinit var ivDetail:ImageView
    private lateinit var ivZoom:ImageView
    private lateinit var tvExplanation:TextView
    private lateinit var tvDate:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detail = intent.getStringExtra(Navigator.DETAIL_KEY)
        apod = Gson().fromJson(detail, Apod::class.java)

        if (apod == null) {
            finish()
        }
        configureToolbar()
        initViews()
        bindApod(apod)
    }

    private fun initViews() {
        ivDetail = findViewById(R.id.iv_detail)
        ivZoom = findViewById(R.id.iv_zoom)
        tvExplanation = findViewById(R.id.tv_explanation)
        tvDate = findViewById(R.id.tv_date)
    }

    private fun bindApod(apod: Apod?) {
        if(apod == null){
            return
        }
        Picasso.get().load(apod.url).into(ivDetail)
        tvExplanation.text = apod.explanation
        tvDate.text = apod.date
    }

    private fun configureToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        apod?.title.let {
            toolbar.title = it
            toolbar.setTitleTextColor(resources.getColor(android.R.color.white))
        }

        this.setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}