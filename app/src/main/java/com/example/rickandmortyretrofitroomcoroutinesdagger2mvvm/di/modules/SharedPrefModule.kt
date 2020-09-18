package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SharedPrefModule() {

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {

        return application.getSharedPreferences("myApp",Context.MODE_PRIVATE)
    }

}