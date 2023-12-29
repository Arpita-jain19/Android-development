package com.example.sougha.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sougha.helper.Constant
import com.example.sougha.helper.PrefHelper
import com.example.sougha.R
import com.example.sougha.databinding.FragmentSplashBinding

class SplashScreenFragment : Fragment() {
    lateinit var prefHelper: PrefHelper
    lateinit var binding:FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        prefHelper = PrefHelper(requireContext())
        val view: View = inflater.inflate(R.layout.fragment_splash, container, false)
        binding=FragmentSplashBinding.inflate(layoutInflater)
//        binding.txtStart.setOnClickListener {
            if(prefHelper.getBoolean(Constant.PREF_IS_LOGIN))
            {
               val intent=Intent(requireContext(),MainActivityHome::class.java)
                startActivity(intent)

            }
            else
            {
                findNavController().navigate(R.id.action_soughsplashscreen_to_registerlogin)
            }
//        }
        Handler(Looper.myLooper()!!).postDelayed({
//            if (prefHelper.getBoolean(Constant.PREF_IS_LOGIN)) {
//                val intent = Intent(requireContext(), MainActivityHome::class.java)
//                Log.d("Check",Constant.PREF_IS_LOGIN)
//                startActivity(intent)
//                onDestroy()
//            } else {
//                    Log.d("Check",Constant.PREF_IS_LOGIN)
//                    findNavController().navigate(R.id.action_soughsplashscreen_to_registerlogin)
//                    }
            findNavController().navigate(R.id.action_soughsplashscreen_to_registerlogin)
        }, 3000)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtStart.setOnClickListener {

        }
    }

}