package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val viewModel:MutableMap<Class<out ViewModel>,Provider<ViewModel>>):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel[modelClass]?.get() as T
    }
}