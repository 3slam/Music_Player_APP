package com.example.musictestagain.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.musictestagain.data.model.Music
import com.example.musictestagain.databinding.MusicItemBinding
import com.example.musictestagain.ui.base.BaseDiffUtil

class MusicAdapter constructor(
    private var list :List<Music> ,
    private var listener: OnMusicListener
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    class MusicViewHolder(val binding: MusicItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(newList :  List<Music> ){
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtil(list, newList,::areItemsSame, ::areContentSame))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = MusicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.binding.music =list[position]
        holder.binding.position =position
        holder.binding.listener = listener
    }
    override fun getItemCount(): Int = list.size
    private fun areItemsSame(oldItem: Music, newItem: Music) = oldItem.hashCode() == newItem.hashCode()
    private fun areContentSame(oldItem: Music, newItem: Music) =   oldItem.source == newItem.source
}

interface OnMusicListener{
    fun onMusicClick(position: Int)
}


