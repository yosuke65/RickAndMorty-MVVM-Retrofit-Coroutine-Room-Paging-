package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui

import android.util.Log
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.EpisodeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainRepository(private val apiService: ApiService) {

    companion object{
        private const val TAG = "MainRepository"
    }

    suspend fun getEpisodesFromApi(pageNum:Int):EpisodeResponse{
        return withContext(Dispatchers.IO){
            Log.d(TAG, "getEpisodesFromApi: ")
            apiService.getEpisodes(pageNum)
        }
    }
}