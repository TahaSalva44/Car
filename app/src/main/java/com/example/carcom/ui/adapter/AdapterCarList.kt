package com.example.carcom.ui.adapter

import com.example.carcom.R
import com.example.carcom.binding.DataBoundAdapter
import com.example.carcom.binding.DataBoundViewHolder
import com.example.carcom.databinding.ItemCarBinding
import com.example.carcom.interfaces.ICar
import com.example.carcom.model.Car

class AdapterCarList(private val carList:ArrayList<Car>,val iCar:ICar) : DataBoundAdapter<ItemCarBinding>(R.layout.item_car) {

    override fun bindItem(
        holder: DataBoundViewHolder<ItemCarBinding>,
        position: Int,
        payloads: List<Any>
    ) {
        holder.binding.data = carList[position]
        holder.binding.callback = iCar
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}