package com.example.haveibeenh4cked.models


import com.google.gson.annotations.SerializedName

data class DarkWebData(
    @SerializedName("current_page")
    val currentPage: String,
    val `data`: List<Data>,
    val from: String,
    @SerializedName("last_page")
    val lastPage: String,
    @SerializedName("per_page")
    val perPage: String,
    val to: String,
    val total: String
)