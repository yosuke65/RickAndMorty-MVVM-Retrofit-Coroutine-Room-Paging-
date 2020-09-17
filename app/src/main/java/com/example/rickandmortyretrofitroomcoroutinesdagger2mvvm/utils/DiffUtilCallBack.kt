package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result

class DiffUtilCallBack : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem== newItem
    }

}