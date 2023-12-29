package com.example.sougha.modals

//data class DataClassSignUp(val API_email:String,val API_password:String,val API_name:String,val API_phone_number:String)
//data class DataClassSignUp(
//    val version:Double,
//    val platform:String
//)
//data class SignUpRequest(
//    val email: String,
//    val password: String,
//    val name: String,
//    val phone_number: String,
//    // Add other fields
//)
//
data class DataClassSignUp(
    val email:String,
    val password:String,
    val name:String,
    val phone_number:String,
    val phone_code:String,
//    val face_login:Boolean,
//    val used_referal_code:String,
//    val g_recaptcha_response:String
    )