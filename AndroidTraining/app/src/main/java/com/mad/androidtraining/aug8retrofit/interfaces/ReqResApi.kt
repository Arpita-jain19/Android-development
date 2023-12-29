package com.mad.androidtraining.aug8retrofit.interfaces

import com.mad.androidtraining.aug8retrofit.models.AuthModel
import com.mad.androidtraining.aug8retrofit.models.UserModel
import com.mad.androidtraining.aug8retrofit.models.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReqResApi {

    @GET("users")
    fun getUsers() : Call<Users>


    @GET("users")
    fun getUsersbyPage(
        @Query("page") page:Int,
    ) : Call<Users>

    @POST("users")
    fun putUsersbyMap(@Body body: Map<String, Any>): Call<UserModel>

    @POST("users")
    fun postUsers(@Body userModel: UserModel): Call<UserModel?>

    @POST("login")
    fun postLogin(@Body authModel: AuthModel): Call<AuthModel?>


    @POST("register")
    fun postRegister(@Body authModel: AuthModel): Call<AuthModel?>

}