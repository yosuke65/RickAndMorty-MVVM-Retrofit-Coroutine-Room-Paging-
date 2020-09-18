package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di

import android.app.Application
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.TestApplication
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules.*
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
//    AndroidInjectionModule::class
//    ActivityBuilderModule::class,
//    TestApiModule::class,
//    RepositoryModule::class,
//    DbModule::class,
//    SharedPrefModule::class,
//    ViewModelModule::class
]
)
interface TestAppComponent : AndroidInjector<TestApplication> {


    @Component.Builder
    interface Builder {

        /**
         * [BindsInstance] annotation is used for, if you want to bind particular object or instance
         * of an object through the time of component construction
         */
        @BindsInstance
        fun application(application: TestApplication) : Builder

        fun build() : TestAppComponent
    }

}