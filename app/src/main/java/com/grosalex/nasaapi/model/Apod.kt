package com.grosalex.nasaapi.model

data class Apod(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val title: String,
    val url: String
)