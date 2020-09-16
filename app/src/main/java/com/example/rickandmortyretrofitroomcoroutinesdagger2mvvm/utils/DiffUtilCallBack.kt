package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode

class DiffUtilCallBack : DiffUtil.ItemCallback<Episode>() {
    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.name == newItem.name
                && oldItem.episode == newItem.episode
                && oldItem.id == newItem.id
    }

}