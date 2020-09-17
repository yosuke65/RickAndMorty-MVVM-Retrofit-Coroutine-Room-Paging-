package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.R
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), CharacterListAdapter.OnCharacterListener {

    companion object{
        private const val TAG = "MainActivity"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mAdapter: CharacterListAdapter

    private lateinit var viewModel: MainViewModel

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
        mAdapter = CharacterListAdapter(this)
        recyclerViewEpisodes.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupObserver() {

        viewModel.getPagedListLiveData().observe(this, Observer {
            Log.d(TAG, "setupObserver")
            mAdapter.submitList(it)
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCharacterClick(result: Result?) {
        Toast.makeText(this, "${result?.name}", Toast.LENGTH_SHORT).show()
    }
}