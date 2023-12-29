package com.mad.androidtraining.aug8retrofit.interfaces


import com.mad.androidtraining.aug8retrofit.models.Entries
import retrofit2.Call
import retrofit2.http.GET

interface PublicApi {

    @GET("entries")
    fun getEntries() : Call<Entries>
}