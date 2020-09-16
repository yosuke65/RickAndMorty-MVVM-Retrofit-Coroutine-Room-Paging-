package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.factory.EpisodeDataSourceFactory
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.EpisodeResponse
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private var pagedListLiveData: LiveData<PagedList<Episode>>


    init {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(2)
            .build()

        val episodeDataSourceFactory = EpisodeDataSourceFactory(mainRepository, viewModelScope)
        pagedListLiveData =
            LivePagedListBuilder<Int, Episode>(episodeDataSourceFactory, config).build()

    }

    fun getPagedListLiveData() = pagedListLiveData


    fun getEpisodes(pageNum: Int = 1) = liveData<Resource<EpisodeResponse>>(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getEpisodesFromApi(pageNum)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}