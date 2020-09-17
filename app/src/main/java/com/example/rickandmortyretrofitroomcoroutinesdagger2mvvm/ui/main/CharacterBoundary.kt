package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDao
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CharacterBoundary(
    private val characterDao: CharacterDao,
    private val scope: CoroutineScope,
    private val repository: MainRepository
) :
    PagedList.BoundaryCallback<Result>() {

    companion object{
        private const val TAG = "CharacterBoundary"
    }

    private var isRequestInProgress = false
    private var lastRequestPage = 1
    private val networkErrors = MutableLiveData<String>()


    /**
     * Database returned 0 items. We should query the backend for more items.
     */
    @MainThread
    override fun onZeroItemsLoaded() {
        Log.d(TAG, "onZeroItemsLoaded")
        requestAndSaveData()
    }

    override fun onItemAtFrontLoaded(itemAtFront: Result) {
        // ignored, since we only ever append to what's in the DB
    }

    /**
     * User reached to the end of the list.
     */
    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: Result) {
        Log.d(TAG, "onItemAtEndLoaded")
        requestAndSaveData()
    }

    /**
     * every time it gets new items, boundary callback simply inserts them into the database and
     * paging library takes care of refreshing the list if necessary.
     */
    private fun insertCharactersIntoDb(results:List<Result>,initial: Boolean) {
        Log.d(TAG, "insertCharactersIntoDb")
        Log.d(TAG, "insertCharactersIntoDb: $results")
        characterDao.insertAllCharacters(results)
    }

    private fun requestAndSaveData() {
        Log.d(TAG, "requestAndSaveData")
        if(isRequestInProgress){
            return
        }else{
            scope.launch(Dispatchers.IO) {
                try {
                    isRequestInProgress = true
                    val response = repository.getEpisodesFromApi(lastRequestPage)
                    if(lastRequestPage == 0){
                        insertCharactersIntoDb(response.results,true)
                    }else{
                        insertCharactersIntoDb(response.results,false)
                    }
                    isRequestInProgress = false
                    lastRequestPage++
                    Log.d(TAG, "Page: $lastRequestPage")


                }catch (e:Exception){
                    isRequestInProgress = false
                    Log.d(TAG, "requestAndSaveData: ${e.toString()}")
                }
            }
        }
    }

//    suspend fun removeCharactersFromDb(){
//        Log.d(TAG, "removeCharactersFromDb")
//        characterDao.removeAllCharacters()
//    }
}