package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.base

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.components.AppComponent
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}