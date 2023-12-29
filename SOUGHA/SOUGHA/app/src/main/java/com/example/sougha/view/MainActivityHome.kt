package com.example.sougha.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.sougha.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigation
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem

class MainActivityHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        val btmNav = findViewById<FluidBottomNavigation>(R.id.btmNav2)
        var index: Int
        //val btm = findViewById<BottomNavigationView>(R.id.btmNav2)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcvHomeActivity) as NavHostFragment
        val navController = navHostFragment.navController
        btmNav?.onTabSelectedListener = object : OnTabSelectedListener,
            com.tenclouds.fluidbottomnavigation.listener.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabSelected(position: Int) {
                when (position) {
                    0 -> navController.navigate(R.id.homeFragment)
                    1 -> navController.navigate(R.id.offersFragment)
                    2 -> navController.navigate(R.id.rewardsFragment)
                    3 -> navController.navigate(R.id.branchFragment)
                    4 -> navController.navigate(R.id.accountFragment)
                }
            }
        }
        btmNav.items =
            listOf(
                FluidBottomNavigationItem(
                    getString(R.string.home),
                    ContextCompat.getDrawable(this, R.drawable.ic_homeicon)
                ),
                FluidBottomNavigationItem(
                    getString(R.string.offers),
                    ContextCompat.getDrawable(this, R.drawable.percent)
                ),
                FluidBottomNavigationItem(
                    getString(R.string.rewards),
                    ContextCompat.getDrawable(this, R.drawable.gift)
                ),
                FluidBottomNavigationItem(
                    getString(R.string.branch),
                    ContextCompat.getDrawable(this, R.drawable.ic_brand)
                ),
                FluidBottomNavigationItem(
                    getString(R.string.account),
                    ContextCompat.getDrawable(this, R.drawable.ic_user)
                )
            )
    }
}


