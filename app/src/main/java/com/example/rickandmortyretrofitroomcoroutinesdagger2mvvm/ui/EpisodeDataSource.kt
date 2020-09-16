package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils.Status
import kotlinx.coroutines.*
import java.lang.Exception

class EpisodeDataSource(

    private val repository: MainRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Episode>() {

    companion object{
        private const val TAG = "EpisodeDataSource"
    }

    var status = MutableLiveData<Status>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Episode>
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

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
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

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        val page = params.key
        scope.launch {
            val data = repository.getEpisodesFromApi(page)
            callback.onResult(data.results,page + 1)
        }
        Log.d(TAG, "loadBefore")
        Log.d(TAG, "Page:$page")
    }

}