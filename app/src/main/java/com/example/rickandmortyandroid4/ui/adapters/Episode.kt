package com.example.rickandmortyandroid4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyandroid4.databinding.ItemEpisodeBinding
import com.example.rickandmortyandroid4.models.episode.EpisodeModel


class EpisodeAdapter(private val list: ArrayList<EpisodeModel>) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: EpisodeModel) {
            binding.tvNameEpisode.text = model.name
            binding.tvEpisode.text = model.episode
            binding.tvAirDate.text = model.airDate
        }
    }

    fun addNewItems(episodeModel: List<EpisodeModel>) {
        list.addAll(episodeModel)
        notifyDataSetChanged()
    }
}