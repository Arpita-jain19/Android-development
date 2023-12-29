package com.example.sougha.viewmodals

import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sougha.databinding.FragmentSignupBinding
import java.util.regex.Pattern

class SignUpViewModel:ViewModel() {
//    var text="hello"
//    val username=MutableLiveData<String>()
//    val userPhoneno=MutableLiveData<String>()
//    val usernameError=MutableLiveData<String>()
//    val userPhonenoError=MutableLiveData<String>()
//    lateinit var binding:FragmentSignupBinding
//    fun userNameValidation():String{
//        val username=username.value
//        if(username==null)
//        {
//            return "username cannot be empty"
//        }
//    }
//    fun validateForm()
//    {
//       if(userNameValidation()!=null)
//       {
//           usernameError.value=userNameValidation()
//       }
//
//    }
    val username=MutableLiveData<String>()
    var usernameError=MutableLiveData<String?>()
    val usermobile=MutableLiveData<String>()
    val userMobileError=MutableLiveData<String?>()
    val userEmail=MutableLiveData<String>()
    val userEmailError=MutableLiveData<String?>()
    val password=MutableLiveData<String>()
    val passwordError=MutableLiveData<String?>()
    val confirmPassword=MutableLiveData<String>()
    val confirmPasswordError=MutableLiveData<String?>()
    val cb=MutableLiveData<CheckBox>()
    fun validateForm()
    {
      if(userNameValidation()!=null)
      {
          usernameError.value=userNameValidation()
      }
      if(userMobileValidation()!=null)
      {
          userMobileError.value=userMobileValidation()
      }
      if(userPasswordValidation()!=null)
      {
          passwordError.value=userPasswordValidation()
      }
      if(confirmPasswordValidation()!=null)
      {
          confirmPasswordError.value=confirmPasswordValidation()
      }
  }

     fun userMobileValidation(): String? {
       val userMobile=usermobile.value
        val pattern = Pattern.compile("^\\d{10}\$")
        val matcher = userMobile?.let { pattern.matcher(it) }
         if (matcher != null) {
             if(!matcher.matches())
             {
                 return "Please enter 10 digit mobile number.."
             } }
         return null
    }

    fun userNameValidation():String?{
        val userName=username.value
        if(userName==null)
        {
            return "userName cannot be Empty"
        }
        return null
    }
    fun userPasswordValidation():String?
    {
        val userPassword=password.value
        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}\$")
        val matcher= userPassword?.let { pattern.matcher(it) }
        if (matcher != null) {
            if(!matcher.matches()) {
                return "Password should contain one uppercase,one lowercase,one spacial character,min length should be 8"
            }
        }
        return null
    }
    fun confirmPasswordValidation():String?
    {
        val confirmPassword=confirmPassword.value
        val password=password.value
        if(confirmPassword!=password)
        {
            return "Password mismatch,Please enter the same password in both the field"
        }
        return null
    }
}