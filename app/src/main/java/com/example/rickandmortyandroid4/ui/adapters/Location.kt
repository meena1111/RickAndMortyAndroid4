package com.example.rickandmortyandroid4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyandroid4.databinding.ItemLocationBinding
import com.example.rickandmortyandroid4.models.location.LocationModel

class LocationAdapter(private val list: ArrayList<LocationModel>) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder =
        LocationViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: LocationModel) {
            binding.tvNameLocation.text = model.name
            binding.tvType.text = model.type
            binding.tvDimension.text = model.dimension
        }
    }

    fun addNewItems(locationModel: List<LocationModel>) {
        list.addAll(locationModel)
        notifyDataSetChanged()
    }
}