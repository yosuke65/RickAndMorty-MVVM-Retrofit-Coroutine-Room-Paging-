package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.R
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.models.Episode
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.row_episode.view.*

class EpisodesListAdapter: PagedListAdapter<Episode,EpisodesListAdapter.MyViewHolder>(DiffUtilCallBack()) {

    
    companion object{
        private const val TAG = "EpisodesListAdapter"
    }
    private var episodes = ArrayList<Episode>()
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(episode: Episode){
            itemView.textViewName.text = episode.name
            itemView.textViewEpisode.text = episode.episode
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_episode,parent,false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        getItem(position)?.let{
            holder.bind(it)
        }
    }

    fun setData(results:ArrayList<Episode>) {
        episodes = results
        notifyDataSetChanged()
    }
}