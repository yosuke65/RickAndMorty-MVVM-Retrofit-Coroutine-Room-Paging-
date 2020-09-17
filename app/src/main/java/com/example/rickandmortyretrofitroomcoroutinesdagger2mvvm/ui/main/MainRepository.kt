package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.util.Log
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.CharacterResponse
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.EpisodeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val apiService: ApiService) {

    companion object{
        private const val TAG = "MainRepository"
    }

    suspend fun getEpisodesFromApi(pageNum:Int):CharacterResponse{
        return withContext(Dispatchers.IO){
            Log.d(TAG, "getEpisodesFromApi: ")
            apiService.getEpisodes(pageNum)
        }
    }
}