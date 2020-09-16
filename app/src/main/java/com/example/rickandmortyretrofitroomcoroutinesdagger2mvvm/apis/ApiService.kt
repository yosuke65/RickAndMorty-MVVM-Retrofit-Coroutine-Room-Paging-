package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.EpisodeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("episode/")
    suspend fun getEpisodes(@Query("page") pageNum:Int):EpisodeResponse
}