package com.example.sougha.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sougha.R
import com.example.sougha.databinding.FragmentWelcomeScreenBinding

class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeScreenBinding.inflate(layoutInflater)
        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_registerlogin_to_signIn)
        }
        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_registerlogin_to_signupscreen)
        }
        return binding.root
    }
}
