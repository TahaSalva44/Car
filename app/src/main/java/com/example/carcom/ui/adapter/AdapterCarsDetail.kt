package com.example.carcom.ui.adapter

import com.example.carcom.R
import com.example.carcom.binding.DataBoundAdapter
import com.example.carcom.binding.DataBoundViewHolder
import com.example.carcom.databinding.ItemCarsDetailBinding
import com.example.carcom.model.CarDetail

class AdapterCarsDetail(private val carsList:List<String>):DataBoundAdapter<ItemCarsDetailBinding>(R.layout.item_cars_detail) {
    override fun bindItem(
        holder: DataBoundViewHolder<ItemCarsDetailBinding>,
        position: Int,
        payloads: List<Any>
    ) {
        holder.binding.data = carsList[position]
    }

    override fun getItemCount(): Int {
        return carsList.size
    }
}