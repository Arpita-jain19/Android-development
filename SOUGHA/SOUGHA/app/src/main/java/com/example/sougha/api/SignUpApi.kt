package com.example.sougha.api
import com.example.sougha.modals.DataClassSignupX
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
interface SignUpApi{
    @FormUrlEncoded
    @POST("signup")
    fun signup(
    @Field("name")name:String,
               @Field("email")email:String,
               @Field("password")password:String,
               @Field("phone number")phone_number:String,
               @Field("phone code")phone_code:String,
               @Field("face login") face_login:Boolean,
//               @Field("referral code") used_referal_code:String,
//                @Field("Recaptcha")g_recaptcha_response:String
    ):Call<DataClassSignupX>
}
//
//interface signupapi {
//    @FormUrlEncoded
//    @POST("signup")
//
//    fun register(@Field("email") API_email:String,
//                 @Field("password") API_password:String,
//                 @Field("name") API_name:String,
//                 @Field("phone number") API_phone_number:String):retrofit2.Call<DataClassSignUp>
//}

//interface signupapi {
//    @POST(SIGN_UP)
//    fun signUp(
//        @Body request: SignUpRequest
//    ): Call<SignUpResponse>
//
//    @POST(SIGN_IN)
//    fun signIn(
//        @Body request: SignInRequest
//    ): Call<SignInResponse>
//}

