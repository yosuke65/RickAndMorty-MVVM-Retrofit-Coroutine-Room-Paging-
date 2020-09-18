package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDao
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDb
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val characterDao: CharacterDao,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {


    companion object {
        private const val LAST_PAGE = "last_page"
        private const val TAG = "MainViewModel"
    }
    /**
     * Typical paging strategy
     */
//    private var pagedListLiveData: LiveData<PagedList<Result>>
//    init {
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(true)
//            .setPageSize(20)
//            .setInitialLoadSizeHint(20)
//            .build()
//
////        val episodeDataSource = EpisodeDataSourceFactory(mainRepository, viewModelScope)
//        val characterDataSourceFactory = characterDao.getAllCharacters()
//        pagedListLiveData =
//            LivePagedListBuilder<Int, Result>(characterDataSourceFactory, config).build()
//
//    }

    /**
     * Single Source of Truth Concept using Room
     */
    private val characters: LiveData<PagedList<Result>> by lazy {
        characterDao.getAllCharacters().toLiveData(
            config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(10)
                .setPrefetchDistance(20)
                .build(),
            boundaryCallback = CharacterBoundary(
                characterDao,
                viewModelScope,
                mainRepository,
                sharedPreferences
            )
        )
    }

    fun getPagedListLiveData() = characters


    /**
     * livedata builder
     */
//    fun getEpisodes(pageNum: Int = 1) = liveData<Resource<EpisodeResponse>>(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = mainRepository.getEpisodesFromApi(pageNum)))
//        } catch (exception: Exception) {
//            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
//        }
//    }
}