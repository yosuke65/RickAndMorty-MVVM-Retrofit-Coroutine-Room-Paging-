package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.components

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.SharedPrefModule
import android.app.Application
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.base.BaseApplication
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.*
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        ActivityBuilderModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        DbModule::class,
        SharedPrefModule::class,
        AndroidInjectionModule::class
    ]
)

interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }


}