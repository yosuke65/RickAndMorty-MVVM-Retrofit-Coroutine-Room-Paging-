package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.EpisodeResponse
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Info
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainRepository
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainViewModel
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ViewModelUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: MainRepository

    private lateinit var mainViewModel:MainViewModel

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup(){
        mainViewModel = MainViewModel(repository)
        Dispatchers.setMain(testCoroutineDispatcher)
    }
    @After
    fun tearDown(){
        testCoroutineDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @Test
    fun getPagedListLiveData() = runBlocking{

        whenever(repository.getEpisodesFromApi(1)).thenReturn(getDummyResponse())
        println(repository.getEpisodesFromApi(1).results.size )
        val data:PagedList<Episode> = mainViewModel.getPagedListLiveData().getValueForTest()!!

        println(mainViewModel.getPagedListLiveData().fetchData().size)

    }


    fun <T> LiveData<T>.getValueForTest(): T? {
        var value: T? = null
        val observer = Observer<T> {
            value = it
        }
        observeForever(observer)
        removeObserver(observer)
        return value
    }

    fun <T> LiveData<PagedList<T>>.fetchData():PagedList<T> {
        return getValueForTest()!!
    }

    fun <T> LiveData<PagedList<T>>.fetchOneMorePage() {
        val pagedList = getValueForTest()!!
        val lastLoadedItemIndex = pagedList.loadedCount - 1
        pagedList.loadAround(lastLoadedItemIndex)
    }


    private fun getDummyResponse():EpisodeResponse {
        val info = Info(count = 10,next = "",prev = "",pages = 3)
        val result = ArrayList<Episode>()
        val episode1 = Episode(air_date = "",characters = listOf(""),created = "",episode = "",name = "", id = 1,url = "")
        val episode2 = Episode(air_date = "",characters = listOf(""),created = "",episode = "",name = "", id = 1,url = "")
        result.add(episode1)
        result.add(episode2)

        return EpisodeResponse(info,result)
    }


}