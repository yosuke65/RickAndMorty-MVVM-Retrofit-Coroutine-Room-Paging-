package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di

import android.app.Application
import androidx.room.Room
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.TestApplication
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDao
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.database.CharacterDb
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class TestDbModule() {


    @Provides
    @Singleton
    fun provideDb(testApplication: TestApplication): CharacterDb {
        return Room.databaseBuilder(testApplication, CharacterDb::class.java,"characterDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(characterDb: CharacterDb): CharacterDao {
        return characterDb.characterDao()
    }
}