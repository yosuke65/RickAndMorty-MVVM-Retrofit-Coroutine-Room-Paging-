package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.app.AlertDialog
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.R
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.location_dialog.view.*
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
        recyclerViewCharacter.apply {
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
        val dialogLayoutLocation =
            LayoutInflater.from(this).inflate(R.layout.location_dialog, null)
        dialogLayoutLocation.text_view_location.text = "Location: ${result?.location?.name}"
        AlertDialog.Builder(this).setView(dialogLayoutLocation).show()
    }

    /**
     * provide correct layout manager depending on the configuration
     */

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d(TAG, "onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(TAG, "onConfigurationChanged: Landscape")
            recyclerViewCharacter.layoutManager = GridLayoutManager(this, 2)
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(TAG, "onConfigurationChanged: Portrait")
            recyclerViewCharacter.layoutManager = LinearLayoutManager(this)
        }
    }
}