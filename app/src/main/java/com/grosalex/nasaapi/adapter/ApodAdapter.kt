package com.grosalex.nasaapi.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.nasaapi.model.Apod
import com.grosalex.nasaapi.viewholder.ApodViewHolder

class ApodAdapter(val apods: ArrayList<Apod>) : RecyclerView.Adapter<ApodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder = ApodViewHolder(parent)
    override fun getItemCount(): Int = apods.size

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        holder.bind(apods[position])
    }
}