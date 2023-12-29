package com.example.sougha.api

import com.example.sougha.modals.DataClassSignupX
import com.example.sougha.modals.SignInRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignInApi {
//    @FormUrlEncoded
//    @POST("signin")
//    fun signIn(
//        @Header("plarform")platform:String="android",
//        @Header("version")version:String="1.3",
//        @Field("email")email:String,
//               @Field("password")password:String,
//               @Field("device_token")device_token:String,
//    @Field("device_type")device_type:String):Call<DataClassSignupX>
    @Headers("platform:android","version:1.3")
    @POST("signin")
    fun signIn(@Body request: SignInRequest):Call<DataClassSignupX>
}
