package com.example.sougha.viewmodals

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.sougha.view.MainActivityHome

class MainViewModel:ViewModel (){
    fun validForm(S:String):String
    {
        if(S.length<12)
        {
            return "false"
        }
        else {
            return "True"
        }
    }
}
