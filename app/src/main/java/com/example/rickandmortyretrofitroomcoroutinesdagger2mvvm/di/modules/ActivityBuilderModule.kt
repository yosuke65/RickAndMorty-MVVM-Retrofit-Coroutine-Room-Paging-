package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
    )
    abstract fun contributeMainActivity(): MainActivity
}