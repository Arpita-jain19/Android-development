package com.mad.androidtraining.aug8retrofit.models

import com.google.gson.annotations.SerializedName

data class Users(

    @SerializedName("page")
    val page: Int = 0,

    @SerializedName("per_page")
    val per_page: Int = 0,

    @SerializedName("total")
    val total: Int = 0,

    @SerializedName("total_pages")
    val total_pages: Int = 0,

    @SerializedName("data")
    val data: ArrayList<UsersData> = arrayListOf(),

    @SerializedName("support")
    val support: UsersSupport
)

data class UsersData(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("email")
    val email: String = "",

    @SerializedName("first_name")
    val first_name: String = "",

    @SerializedName("last_name")
    val last_name: String = "",

    @SerializedName("avatar")
    val avatar: String = ""
)

data class UsersSupport(

    @SerializedName("url")
    val url: String = "",

    @SerializedName("text")
    val text: String = ""
)
