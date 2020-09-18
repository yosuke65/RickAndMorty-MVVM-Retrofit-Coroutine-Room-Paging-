package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.TestApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SharedPrefModule() {

    @Singleton
    @Provides
    fun provideSharedPreferences(testApplication: TestApplication): SharedPreferences {

        return testApplication.getSharedPreferences("myApp", Context.MODE_PRIVATE)
    }

}