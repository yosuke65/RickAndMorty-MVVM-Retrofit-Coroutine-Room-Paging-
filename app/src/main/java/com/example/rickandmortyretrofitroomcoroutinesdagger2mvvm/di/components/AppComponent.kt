package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.components

import android.app.Application
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.base.BaseApplication
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.ActivityBuilderModule
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.ApiModule
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.RepositoryModule
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        ActivityBuilderModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
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