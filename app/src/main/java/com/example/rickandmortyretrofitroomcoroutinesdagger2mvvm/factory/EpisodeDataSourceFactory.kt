package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.factory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.EpisodeDataSource
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.MainRepository
import kotlinx.coroutines.CoroutineScope


class EpisodeDataSourceFactory(private val repository: MainRepository, private val scope:CoroutineScope): DataSource.Factory<Int, Episode>() {

    companion object{
        private const val TAG = "EpisodeDataSourceFactor"
    }

    override fun create(): DataSource<Int, Episode> {
        Log.d(TAG, "create")
        return EpisodeDataSource(repository,scope)
    }
}