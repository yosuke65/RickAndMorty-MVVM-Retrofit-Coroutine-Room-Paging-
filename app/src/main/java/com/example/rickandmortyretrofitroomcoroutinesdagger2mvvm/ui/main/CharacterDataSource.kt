package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.provider.VoicemailContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import kotlinx.coroutines.*
import java.lang.Exception

class CharacterDataSource(

    private val repository: MainRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Result>() {

    companion object{
        private const val TAG = "EpisodeDataSource"
    }


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        scope.launch(Dispatchers.IO) {
                try {
                    val data = repository.getEpisodesFromApi(1)
                    callback.onResult(data.results,null,2)
                    Log.d(TAG, "loadInitial: ${data.results}")
                }catch (e:Exception){
                    Log.d(TAG, "loadInitial: failed to fetch data")
                }
        }
        Log.d(TAG, "loadInitial")

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key
        scope.launch(Dispatchers.IO) {
                try{
                    val data = repository.getEpisodesFromApi(page)
                    callback.onResult(data.results,page + 1)
                }catch (e:Exception){
                    Log.d(TAG, "loadAfter: failed to fetch data")
                }
        }
        Log.d(TAG, "loadAfter")
        Log.d(TAG, "Page: $page")

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key
        scope.launch {
            val data = repository.getEpisodesFromApi(page)
            callback.onResult(data.results,page + 1)
        }
        Log.d(TAG, "loadBefore")
        Log.d(TAG, "Page:$page")
    }

}