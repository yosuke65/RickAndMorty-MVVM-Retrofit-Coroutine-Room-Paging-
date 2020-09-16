package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.MainScope

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
        modules = [
            RecyclerViewAdapterModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}