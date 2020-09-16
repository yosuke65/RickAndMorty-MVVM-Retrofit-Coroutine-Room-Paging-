package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.R
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils.Status
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var mAdapter:EpisodesListAdapter

    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        setupViewModel()
        setupObserver()
        setupUI()
    }

    private fun setupUI() {
        recyclerViewEpisodes.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupObserver() {
//        viewModel.getEpisodes().observe(this, Observer {
//            it?.let{
//                when(it.status){
//                    Status.SUCCESS ->{
//                        Log.d(TAG, "setupObserver: SUCCESS")
//                        progressBar.visibility = View.INVISIBLE
//                        mAdapter.setData(it.data!!.results)
//                    }
//                    Status.ERROR ->{
//                        Log.d(TAG, "setupObserver: ERROR")
//                        progressBar.visibility = View.INVISIBLE
//                        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
//                    }
//                    Status.LOADING ->{
//                        Log.d(TAG, "setupObserver: LOADING")
//                        progressBar.visibility = View.VISIBLE
//                    }
//                }
//            }
//
//        })
        viewModel.getPagedListLiveData().observe(this, Observer {
            Log.d(TAG, "setupObserver")
            mAdapter.submitList(it)
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
    }
}