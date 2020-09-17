package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils

import androidx.room.TypeConverter
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Location
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class LocationTypeConverter {
    val gson = GsonBuilder().create()
    @TypeConverter
    fun locationToString(location:Location):String{
        return if(location == null){
            ""
        }else{
            gson.toJson(location)
        }
    }
}