package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.R
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Result
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.row_character.view.*

class CharacterListAdapter(private val onCharacterListener: OnCharacterListener) :
    PagedListAdapter<Result, CharacterListAdapter.MyViewHolder>(DiffUtilCallBack()) {

    companion object {
        private const val TAG = "CharacterListAdapter"
    }


    inner class MyViewHolder(view: View, private val onCharacterListener: OnCharacterListener) : RecyclerView.ViewHolder(view), View.OnClickListener {

        fun bind(result: Result) {
            itemView.text_view_name.text = result.name
            itemView.text_view_species.text = result.species
            itemView.text_view_status.text = result.status
            Glide.with(itemView.image_view_character).load(result.image)
                .into(itemView.image_view_character)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            onCharacterListener?.onCharacterClick(getItem(adapterPosition))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_character, parent, false),
            onCharacterListener!!
        )
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    interface OnCharacterListener {
        fun onCharacterClick(result: Result?)
    }

}