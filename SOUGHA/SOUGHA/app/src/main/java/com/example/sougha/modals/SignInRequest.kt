package com.example.sougha.modals

data class SignInRequest(
    val email:String,
    val password:String,
    val device_token:String,
    val device_type:String
)
