package com.example.sougha.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sougha.R
import com.example.sougha.api.SignInApi
import com.example.sougha.databinding.FragmentSigninBinding
import com.example.sougha.helper.Constant
import com.example.sougha.helper.PrefHelper
import com.example.sougha.modals.DataClassSignupX
import com.example.sougha.modals.SignInRequest
import com.example.sougha.`object`.RetrofitClient
import com.example.sougha.viewmodals.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSigninBinding
    private lateinit var prefHelper: PrefHelper
    private lateinit var MainViewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefHelper = PrefHelper(requireContext())
        MainViewModel = MainViewModel()
        binding = FragmentSigninBinding.inflate(layoutInflater)
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_registerlogin)
        }
        binding.btnSignIn.setOnClickListener {
            //getData(prefHelper.getString(Constant.PREF_MOBILE_NO),prefHelper.getString(Constant.PREF_PASSWORD))
            val userEmail = prefHelper.getString(Constant.PREF_EMAIL_ID)
            val userPassword = prefHelper.getString(Constant.PREF_PASSWORD)
            if (userEmail != null) {
                if (userPassword != null) {
                    Log.d("Checkvalues", userEmail)
                    loginUser()
                }
            }
        }
//        val userPhone=prefHelper.getString(Constant.PREF_MOBILE_NO)
//        val userPassword=prefHelper.getString(Constant.PREF_PASSWORD)
//        MainViewModel= MainViewModel()
        return binding.root
    }

    private fun loginUser() {
        val email = binding.etEmail.text.toString()
        //val email="jaimin.panchal@brainvire.com"
        val password = binding.etPassword.text.toString()
        //val password="Test@123"

        if (email.isEmpty()) {
            binding.etEmail.error = "Please enter email"
            requestFocus(binding.etEmail)
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Please enter password"
            requestFocus(binding.etPassword)
        }

        if (email.isNotEmpty() && password.isNotEmpty()) {
            val device_token =
                "fXUd73DOREmF0LdY9bn4oY:APA91bGdt8APNc_sZ1hzr3fWkN16fWEKydDIxA8hxKyz2DWVf8RwNG3Ly6_THmstJ9b2Gq5Dwc5nwozPNimMDbpCkNbcJbe-_eKBItDxQ3Nsouh7j61V0i5FXxxouQW9R2mKHHkDwGvZ"
            val device_type = "Android"
            loginApiCall(email, password, device_token, device_type)
        }
    }

    private fun loginApiCall(
        email: String,
        password: String,
        deviceToken: String,
        deviceType: String
    ) {
        binding.progressBar.visibility = View.VISIBLE
        val apiService = RetrofitClient.retrofit.create(SignInApi::class.java)
        val signInRequest = SignInRequest(email, password, deviceToken, deviceType)
        val call = apiService.signIn(signInRequest)
        call.enqueue(object : Callback<DataClassSignupX> {
            override fun onResponse(
                call: Call<DataClassSignupX>,
                response: Response<DataClassSignupX>
            ) {
                Log.i("Entered email", email)
                Log.i("CHECK_ERROR2", "onResponse:  ${response.code()}")
                Log.i("CHECK_ERROR2", "onResponse:  ${response.body()}")
                if (response.code() == 200) {
                    val intent = Intent(requireContext(), MainActivityHome::class.java)
                    startActivity(intent)
                    binding.progressBar.visibility = View.GONE
                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show()
                }

            }
            override fun onFailure(call: Call<DataClassSignupX>, t: Throwable) {
                Log.e("Api error", "Api call failed :$(t.message)")
            }
        }
        )
    }

    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            view.requestFocus()
            (requireActivity()).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }
}