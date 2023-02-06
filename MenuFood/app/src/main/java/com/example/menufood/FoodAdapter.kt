package com.example.menufood

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.menufood.databinding.FoodItemBinding


class FoodAdapter : ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var binding: FoodItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        if (holder is ViewHolder) {
            val item = getItem(pos)
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val itemBinding: FoodItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Food) {

            itemBinding.tvFoodName.apply {
                text = item.name.toString()
                textSize = SharedPref(context).getFontSize()
            }
            itemBinding.tvFoodPrice.apply {
                text = item.price.toString()
                textSize = SharedPref(context).getFontSize()
            }

            itemBinding.tvImage.setImageResource(item.imgUrl)
        }
    }
}