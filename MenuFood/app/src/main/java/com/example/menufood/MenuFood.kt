package com.example.menufood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.menufood.databinding.FragmentMenuFoodBinding

class MenuFood : Fragment(R.layout.fragment_menu_food) {
    private var _binding: FragmentMenuFoodBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMenuFoodBinding.bind(view)
        val adapter = FoodAdapter()
        binding.foodListView.adapter = adapter
        adapter.submitList(
            listOf(
                Food("Burger", 21.5f, R.drawable.burger),
                Food("Burger2", 22.5f, R.drawable.burger),
                Food("Burger3", 23.5f, R.drawable.burger),
                Food("Burger5", 24.5f, R.drawable.burger),
                Food("Burger6", 16.5f, R.drawable.burger),
                Food("Burger7", 15.5f, R.drawable.burger),
                Food("Burger8", 17.5f, R.drawable.burger),
                Food("Burger9", 12.5f, R.drawable.burger),
                Food("Burger10", 10.5f, R.drawable.burger),
                Food("Burger11", 11.5f, R.drawable.burger),
                Food("Burger12", 16.5f, R.drawable.burger),
                Food("Burger2", 18.5f, R.drawable.burger),
                Food("Burger13", 9.5f, R.drawable.burger),
                Food("Burger14", 20.5f, R.drawable.burger),
                Food("Burger15", 5.5f, R.drawable.burger),
                Food("Burger16", 10.5f, R.drawable.burger),
                Food("Burger17", 9.5f, R.drawable.burger),
                Food("Burger18", 13.5f, R.drawable.burger),
                Food("Burger19", 22.5f, R.drawable.burger),
                Food("Burger20", 20.5f, R.drawable.burger),
            )
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}