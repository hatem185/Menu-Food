package com.example.menufood.ui.food

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.menufood.R
import com.example.menufood.databinding.FragmentMenuFoodBinding
import com.example.menufood.model.SharedPref

class MenuFood : Fragment(R.layout.fragment_menu_food), FoodAdapter.OnItemListner {
    private var _binding: FragmentMenuFoodBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FoodViewModel>()


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMenuFoodBinding.bind(view)
        val adapter = FoodAdapter(this)
        adapter.fontSize = SharedPref(requireContext()).getFontSize()
        binding.foodListView.adapter = adapter
        viewModel.foodList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onItemClickListner(pos: Int) {
        val action = MenuFoodDirections.actionMenuFoodToDetailsFoodItem(pos)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}