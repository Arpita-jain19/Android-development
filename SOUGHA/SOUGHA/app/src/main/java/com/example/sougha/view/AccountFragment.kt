package com.example.sougha.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sougha.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAccountBinding.inflate(layoutInflater)
        binding.imgExapndCollapse.setOnClickListener {
            if (binding.groupAccountDetails.visibility == View.GONE) {
                binding.groupAccountDetails.visibility = View.VISIBLE
            } else {
                binding.groupAccountDetails.visibility = View.GONE
            }
        }
        binding.imgCPref.setOnClickListener {
            if (binding.groupCommunicationPref.visibility == View.GONE) {
                binding.groupCommunicationPref.visibility = View.VISIBLE
            } else {
                binding.groupCommunicationPref.visibility = View.GONE
            }
        }
        binding.imgAppPref.setOnClickListener {
            if(binding.groupAppPref.visibility==View.GONE)
            {
                binding.groupAppPref.visibility=View.VISIBLE
            }
            else{
                binding.groupAppPref.visibility=View.GONE
            }
        }
        return binding.root
    }
}

