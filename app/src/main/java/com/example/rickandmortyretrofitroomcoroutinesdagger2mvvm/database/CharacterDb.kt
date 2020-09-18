package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database

import android.content.Context
import androidx.room.*
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Location
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result


@Database(entities = [Result::class], version = 14, exportSchema = false)
//@TypeConverters(value = [Location::class])
abstract class CharacterDb : RoomDatabase() {


    abstract fun characterDao(): CharacterDao

//    companion object {
//        private var INSTANCE: CharacterDb? = null
//        fun getInstance(context: Context):CharacterDb{
//            if(INSTANCE == null){
//                INSTANCE = Room.databaseBuilder(
//                    context,
//                    CharacterDb::class.java,
//                    "characterDb")
//                    .build()
//            }
//            return INSTANCE as CharacterDb
//        }
//    }
}