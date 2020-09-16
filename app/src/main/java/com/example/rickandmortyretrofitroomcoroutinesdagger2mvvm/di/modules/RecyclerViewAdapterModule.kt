package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.di.modules

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.EpisodesListAdapter
import dagger.Module
import dagger.Provides

@Module
class RecyclerViewAdapterModule {
    @Provides
    fun providesEpisodeListAdapter() = EpisodesListAdapter()
}