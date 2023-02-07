package com.example.menufood.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.menufood.R
import com.example.menufood.databinding.FoodItemBinding


class FoodAdapter(var actionFrom: OnItemListner) :
    ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    var fontSize = 16f
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
            itemBinding.foodItem.setOnClickListener {
                actionFrom.onItemClickListner(adapterPosition)
            }
            itemBinding.tvFoodName.apply {
                text = item.name
                textSize = fontSize
            }
            itemBinding.tvFoodPrice.apply {
                text = item.price.toString()
                textSize = fontSize
            }
            itemBinding.tvImage.setImageResource(R.drawable.burger)
        }

    }

    interface OnItemListner {
        fun onItemClickListner(pos: Int) {}
    }
}