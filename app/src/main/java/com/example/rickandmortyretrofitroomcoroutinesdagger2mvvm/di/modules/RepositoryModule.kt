package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(apiService: ApiService) =
        MainRepository(
            apiService
        )
}