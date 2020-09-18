package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class TestApiModule {

    @Singleton
    @Provides
    open fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    open fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}