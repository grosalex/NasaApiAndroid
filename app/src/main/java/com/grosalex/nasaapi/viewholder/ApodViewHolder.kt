package com.grosalex.nasaapi.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.nasaapi.Navigator
import com.grosalex.nasaapi.R
import com.grosalex.nasaapi.model.Apod
import com.squareup.picasso.Picasso

class ApodViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.apod_item, parent, false)) {
    private val ivApod: ImageView = itemView.findViewById(R.id.iv_apod)
    fun bind(apod: Apod) {
        Picasso.get().load(apod.url).into(ivApod)
        itemView.setOnClickListener {
            Navigator.openDetail(it.context, apod)
        }
    }
}