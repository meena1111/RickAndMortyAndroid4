package com.example.rickandmortyandroid4.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyandroid4.R
import com.example.rickandmortyandroid4.databinding.ItemCharacterBinding
import com.example.rickandmortyandroid4.models.character.CharacterModel

class CharacterAdapter(private val list: ArrayList<CharacterModel>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: CharacterModel) {
            binding.characterIv.load(model.image)
            binding.nameCharacterTv.text = model.name
            binding.statusTv.text = model.status
            binding.speciesTv.text = model.species
            binding.lastLocationTv.text = model.location.name
            binding.firstSeenTv.text = model.origin.name
            checkStatus(model, binding)
        }
    }

    fun addNewItems(characterModel: List<CharacterModel>) {
        list.addAll(characterModel)
        notifyDataSetChanged()
    }

    @SuppressLint("ResourceAsColor")
    private fun checkStatus(model: CharacterModel, binding: ItemCharacterBinding) {
        when (model.status.trim()) {
            "Alive" -> binding.statusIv.load(R.drawable.ic_status_green)
            "Dead" -> binding.statusIv.load(R.drawable.ic_status_red)
        }
    }
    }