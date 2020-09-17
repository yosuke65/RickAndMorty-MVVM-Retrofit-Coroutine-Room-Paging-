package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDao
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDb
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DbModule() {

    @Provides
    @Singleton
    fun provideDb(application: Application): CharacterDb{
        return Room.databaseBuilder(application,CharacterDb::class.java,"characterDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(characterDb: CharacterDb):CharacterDao{
        return characterDb.characterDao()
    }
}