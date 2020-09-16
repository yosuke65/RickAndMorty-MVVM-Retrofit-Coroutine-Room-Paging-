package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
}