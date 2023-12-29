package com.example.sougha.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.sougha.R
import com.example.sougha.adapter.AdapterHomeScreeen
import com.example.sougha.adapter.AdapterHomeScreen2
import com.example.sougha.adapter.AdapterViewPager
import com.example.sougha.databinding.FragmentHomeBinding
import com.example.sougha.modals.HomePageDataClass
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var dotsIndicator: WormDotsIndicator
    private lateinit var userAdapter: AdapterHomeScreen2
    private lateinit var userAdapter2: AdapterHomeScreeen
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val images = listOf(
            R.drawable.img_logo_partneroffer,
            R.drawable.img_logo_partneroffer,
            R.drawable.img_logo_partneroffer
        )
        viewPager = binding.viewPager
        dotsIndicator = binding.dotsIndicator
        viewPager.adapter = AdapterViewPager(images)
        dotsIndicator.setStrokeDotsIndicatorColor(R.color.black)
        dotsIndicator.setViewPager2(binding.viewPager)
        val recyclerview = binding.rvPartner
        val recyclerview2 = binding.rvRecommendation
        showData()
        showData2()
        recyclerview.adapter = userAdapter
        recyclerview2.adapter = userAdapter2
        return binding.root
    }

    private fun showData() {
        val data = ArrayList<HomePageDataClass>()
        userAdapter = AdapterHomeScreen2(data, requireContext())
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june"
            )
        )
    }

    private fun showData2() {
        val data = ArrayList<HomePageDataClass>()
        userAdapter2 = AdapterHomeScreeen(data, requireContext())
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june 2022"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june 2022"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june 2022"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june 2022"
            )
        )
        data.add(
            HomePageDataClass(
                R.drawable.img_logo_partneroffer,
                "2XL",
                "HOME",
                "35% OFF across all UAE",
                "Valid until:30 june 2022"
            )
        )
    }
}