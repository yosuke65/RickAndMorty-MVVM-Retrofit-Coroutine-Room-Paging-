package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result


@Dao
interface CharacterDao {
    @Query("Select * from character")
    fun getAllCharacters(): DataSource.Factory<Int,Result>


    @Insert
    fun insertAllCharacters(results: List<Result>)

//    @Delete
//    fun removeAllCharacters()
}