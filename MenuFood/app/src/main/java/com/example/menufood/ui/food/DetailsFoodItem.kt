package com.example.menufood.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.menufood.R
import com.example.menufood.databinding.FragmentDetailsFoodItemBinding

class DetailsFoodItem : Fragment(R.layout.fragment_details_food_item) {
    private var _binding: FragmentDetailsFoodItemBinding? = null
    private val binding get() = _binding!!
    private val foodViewModel by viewModels<FoodViewModel>()
    private val arges by navArgs<DetailsFoodItemArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsFoodItemBinding.bind(view)
        val foodItem = foodViewModel.getFoodAt(arges.foodId)
        binding.apply {
            foodItem.apply {
                priceFoodDet.text = price.toString()
                nameFoodDet.text = name
                imageFoodDet.setImageResource(imgUrl)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}