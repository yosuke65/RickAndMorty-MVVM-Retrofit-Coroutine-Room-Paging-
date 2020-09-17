package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.factory

import androidx.paging.DataSource
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.CharacterDataSource
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainRepository
import kotlinx.coroutines.CoroutineScope


class EpisodeDataSourceFactory(private val repository: MainRepository, private val scope:CoroutineScope): DataSource.Factory<Int, Result>() {

    companion object{
        private const val TAG = "EpisodeDataSourceFactor"
    }

    override fun create(): DataSource<Int, Result> {
//        Log.d(TAG, "create")
        return CharacterDataSource(
            repository,
            scope
        )
    }
}