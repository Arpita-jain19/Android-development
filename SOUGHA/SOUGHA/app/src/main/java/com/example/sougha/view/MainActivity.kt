package com.example.sougha.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.sougha.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeStatusBarColor()
    }
    private fun changeStatusBarColor() {
        val window: Window = window
        window.statusBarColor = getColor(R.color.darkbrown)
    }
}