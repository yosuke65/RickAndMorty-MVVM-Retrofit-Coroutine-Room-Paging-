package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDao
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDb
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.CharacterBoundary
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainRepository
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoTestRule
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
//@Config(manifest= Config.NONE, sdk = [Build.VERSION_CODES.JELLY_BEAN, Build.VERSION_CODES.JELLY_BEAN_MR1])
class ViewModelUnitTest {

    @get:Rule
    val MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: MainRepository

    private lateinit var mainViewModel:MainViewModel
    private lateinit var characterDao: CharacterDao
    private lateinit var db: CharacterDb

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setup(){

        //Need to add testImplementation 'androidx.test:core:1.3.0'
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, CharacterDb::class.java).build()
        characterDao = db.characterDao()
        mainViewModel = MainViewModel(repository,characterDao)
        Dispatchers.setMain(testCoroutineDispatcher)
    }
    @ExperimentalCoroutinesApi
    @After
    fun tearDown(){
        testCoroutineDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getPagedListLiveData() = runBlockingTest(){

        val charLiveData = characterDao.getAllCharacters().toLiveData(
            config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(20)
                .build(),
            boundaryCallback = CharacterBoundary(
                characterDao,
                mainViewModel.viewModelScope,
                repository
        ))
        characterDao.insertAllCharacters(getDummyResponse())

        println(charLiveData.value?.size)

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


    private fun getDummyResponse():List<Result> {

        val list = ArrayList<Result>()
        val result1 = Result(0,"","","","")
        val result2 = Result(1,"","","","")
        list.add(result1)
        list.add(result2)

        return list
    }


}