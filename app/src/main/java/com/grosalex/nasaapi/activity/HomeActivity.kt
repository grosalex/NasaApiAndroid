package com.grosalex.nasaapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.nasaapi.R
import com.grosalex.nasaapi.adapter.ApodAdapter
import com.grosalex.nasaapi.contract.ApodContract
import com.grosalex.nasaapi.model.Apod
import com.grosalex.nasaapi.presenter.ApodPresenter
import com.grosalex.nasaapi.provider.ApodProvider

class HomeActivity : AppCompatActivity(), ApodContract.View {

    lateinit var loader: ProgressBar
    lateinit var rvHome: RecyclerView
    lateinit var apodAdapter: ApodAdapter
    lateinit var apodPresenter: ApodPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loader = findViewById(R.id.loader)
        rvHome = findViewById(R.id.rv_home)
        val layoutManager = GridLayoutManager(this, 3)
        rvHome.layoutManager = layoutManager
        apodAdapter = ApodAdapter(ArrayList<Apod>())
        rvHome.adapter = apodAdapter

        apodPresenter = ApodPresenter(this, ApodProvider())
        apodPresenter.loadThirtyDays()
    }

    override fun load() {
        loader.visibility = View.VISIBLE
    }

    override fun add(apod: Apod) {
        loader.visibility = View.GONE
        apodAdapter.apods.add(apod)
        apodAdapter.notifyItemInserted(apodAdapter.itemCount - 1)
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
