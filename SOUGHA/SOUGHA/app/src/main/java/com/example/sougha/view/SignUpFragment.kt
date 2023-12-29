package com.example.sougha.view

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sougha.R
import com.example.sougha.api.SignUpApi
import com.example.sougha.databinding.FragmentSignupBinding
import com.example.sougha.helper.Constant
import com.example.sougha.helper.PrefHelper
import com.example.sougha.modals.DataClassSignupX
import com.example.sougha.`object`.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpFragment : Fragment() {
    // private lateinit var SignUpViewModel:SignUpViewModel
    lateinit var binding: FragmentSignupBinding
    lateinit var prefHelper: PrefHelper
//    lateinit var signUpViewModel: SignUpViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefHelper = PrefHelper(requireContext())
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        //val binding:FragmentSignupBinding=DataBindingUtil.setContentView(requireContext(),R.layout.fragment_signup)
        // binding = FragmentSignupBinding.inflate(layoutInflater)
        //binding.signupviewmodel=signUpViewModel
        binding.imgBackArrow.setOnClickListener {
            findNavController().navigate(R.id.action_signupscreen_to_registerlogin)
        }
        validateForm()
        textOneSpan()
        // SignUpViewModel.validateForm()
        return binding.root
    }
    private fun validateForm() {
        binding.btnSignUP.setOnClickListener {
            val etFname = binding.etFname.text.toString()
            val etMobileno = binding.etMobileno.text.toString()
            val etEmail = binding.etEmail.text.toString()
            val etPwd = binding.etPassword.text.toString()
            val etCPwd = binding.etCPassword.text.toString()
            val selectedCountryCode=binding.ccPicker.selectedCountryCode
            val isFaceLogin=binding.switchFaceID.isChecked
            val cb = binding.cbAgree
            if (etFname.isEmpty()) {
                binding.etFname.error = "Please enter First name..."
                requestFocus(binding.etFname)
                return@setOnClickListener
            } else if (etMobileno.isEmpty()) {
                binding.etMobileno.error = "Please enter Mobile no..."
                requestFocus(binding.etMobileno)
                return@setOnClickListener
            } else if (!validatePhoneno(etMobileno)) {
                binding.etMobileno.error = "Please enter 10digit mobile no."
                requestFocus(binding.etMobileno)
                return@setOnClickListener
            } else if (etEmail.isEmpty()) {
                binding.etEmail.error = "Please enter email"
                requestFocus(binding.etEmail)
                return@setOnClickListener
            } else if (!validateEmail(etEmail)) {
                binding.etEmail.error = "Please enter valid email"
                requestFocus(binding.etEmail)
                return@setOnClickListener
            } else if (etPwd.isEmpty()) {
                binding.etPassword.error = "Please enter valid password"
                requestFocus(binding.etPassword)
                return@setOnClickListener
            } else if (!validatePassword(etPwd)) {
                binding.etPassword.error = getString(R.string.password_validation)
                requestFocus(binding.etPassword)
                return@setOnClickListener

            } else if (etCPwd.isEmpty()) {
                binding.etCPassword.error = "This field cannot be empty "
                requestFocus(binding.etCPassword)
                return@setOnClickListener
            } else if (etPwd != etCPwd) {
                Toast.makeText(
                    requireContext(),
                    "Password mismatch,Please enter the same password",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else if (!binding.cbAgree.isChecked) {
                Toast.makeText(
                    requireContext(),
                    "Please select terms and conditions..",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Log.d("Selected country code",isFaceLogin.toString())
                prefHelper.putString(Constant.PREF_EMAIL_ID, etEmail)
                prefHelper.putString(Constant.PREF_PASSWORD, etPwd)
                prefHelper.putBoolean(Constant.PREF_IS_LOGIN, true)
                Toast.makeText(requireContext(), "User Registered", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signupscreen_to_signIn)
                registerUser(etFname,etEmail,etPwd,etMobileno,selectedCountryCode,isFaceLogin)
            }
        }
    }
    private fun registerUser(
        etFname: String,
        etEmail: String,
        etPwd: String,
        etMobileno: String,
        selectedCountryCode: String,
        face_login:Boolean
    ) {
        val apiService = RetrofitClient.retrofit.create(SignUpApi::class.java)
        val call = apiService.signup(etFname, etEmail, etPwd, etMobileno, selectedCountryCode,face_login)
        call.enqueue(object : Callback<DataClassSignupX> {
            override fun onResponse(
                call: Call<DataClassSignupX>,
                response: Response<DataClassSignupX>
            ) {
                Log.d("Entered email",etEmail)
                Log.i("CHECK_ERROR", "onResponse: mad ${response.code()}")
                Log.i("CHECK_ERROR", "onResponse: mad ${response.message()}")
            }
            override fun onFailure(call: Call<DataClassSignupX>, t: Throwable) {
                Log.d("Entered email2",etEmail)
            }
        }
        )
    }
    private fun validatePhoneno(number: String): Boolean {
        val pattern = Pattern.compile("^\\d{10}\$")
        val matcher = pattern.matcher(number)
        return matcher.matches()

    }
    private fun validateEmail(email: String): Boolean {
        val pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$")
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    private fun validatePassword(password: String): Boolean {
        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}\$")
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }
    private fun textOneSpan() {
        val underlineSpan = UnderlineSpan()
        val spannableText = binding.txtTermsandCondition
        val color = Color.parseColor("#87744E")
        val fColor = ForegroundColorSpan(color)
        //val fColor=ContextCompat.getColor(requireContext(),R.color.brown)
        val spannableString = SpannableString(getString(R.string.terms_and_conditions))
        spannableString.setSpan(fColor, 78, 91, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(underlineSpan, 78, 91, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableText.text = spannableString
    }
    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            view.requestFocus()
            (requireActivity()).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }
}