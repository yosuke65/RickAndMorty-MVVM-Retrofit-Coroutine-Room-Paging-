package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models

import androidx.room.*
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils.LocationTypeConverter

data class CharacterResponse(
    val info: Info,
    val results: List<Result>
)

//data class Info(
//    val count: Int,
//    val next: String,
//    val pages: Int,
//    val prev: Any
//)

@Entity(tableName = "character")
data class Result(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name="image_url")
    val image: String,
    @Embedded
    val location: Location,
    val name: String,
    val species: String,
    val status: String
)


data class Location(
    @ColumnInfo(name="location_name")
    val name: String,
    val url: String
)
