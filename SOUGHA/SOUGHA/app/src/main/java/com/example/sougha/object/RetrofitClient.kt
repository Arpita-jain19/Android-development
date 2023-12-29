package com.example.sougha.`object`

import com.example.sougha.api.SignInApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL_UAT = "https://soughahadmin.demo.brainvire.dev/api/v1/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_UAT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val signupapi = retrofit.create(SignInApi::class.java)
}
