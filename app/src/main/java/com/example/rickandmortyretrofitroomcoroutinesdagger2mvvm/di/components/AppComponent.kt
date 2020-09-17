package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.components

import android.app.Application
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.apis.ApiService
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.base.BaseApplication
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.*
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
        DbModule::class,
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