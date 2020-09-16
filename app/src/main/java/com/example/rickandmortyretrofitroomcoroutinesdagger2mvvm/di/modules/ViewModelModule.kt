package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.annotations.ViewModelKey
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.MainViewModel
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel):ViewModel
}