package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.DaggerTestAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class TestApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        //To generate Dagger component you have to run the UI test first
        return DaggerTestAppComponent.builder().application(this).build()
    }
}