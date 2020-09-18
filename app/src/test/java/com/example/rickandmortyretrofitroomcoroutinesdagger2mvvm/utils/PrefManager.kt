package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils

import android.content.Context
import android.content.SharedPreferences

object PrefManager {

    private lateinit var sharedPreferences: SharedPreferences

    fun getInstance(context: Context):SharedPreferences {
        if (sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("myApp",Context.MODE_PRIVATE)
        }
        return sharedPreferences
    }
}