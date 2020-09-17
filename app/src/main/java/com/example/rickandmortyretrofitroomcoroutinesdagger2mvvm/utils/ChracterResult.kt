package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result

data class CharacterResult(
    val data: LiveData<PagedList<Result>>,
    val error: LiveData<String>
) {
}