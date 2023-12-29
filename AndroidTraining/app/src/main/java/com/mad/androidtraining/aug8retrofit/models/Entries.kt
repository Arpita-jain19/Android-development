package com.mad.androidtraining.aug8retrofit.models

import com.google.gson.annotations.SerializedName

data class Entries(
    @SerializedName("count")
    val count: Int = 0,

    @SerializedName("entries")
    val entries: ArrayList<EntriesList> = arrayListOf(),
)

data class EntriesList(
    @SerializedName("API")
    val api: String = "",
    @SerializedName("Description")
    val description: String = "",
    @SerializedName("Auth")
    val auth: String = "",
    @SerializedName("HTTPS")
    val https: Boolean = false,
    @SerializedName("Cors")
    val cors: String = "",
    @SerializedName("Link")
    val link: String = "",
    @SerializedName("Category")
    val category: String = ""
)