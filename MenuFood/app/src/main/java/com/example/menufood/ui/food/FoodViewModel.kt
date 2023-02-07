package com.example.menufood.ui.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.menufood.model.FoodDB
import com.example.menufood.model.FoodDBImplment

class FoodViewModel : ViewModel() {
    private var _foodList: MutableLiveData<List<Food>> = MutableLiveData(emptyList())
    val foodList: LiveData<List<Food>> get() = _foodList
    private val repository: FoodDB = FoodDBImplment()

    init {
        getListOfFood()
    }

    private fun getListOfFood() {
        _foodList.value = repository.getFoodList()
    }

    fun removeFood() {
        repository.removeItem()
        getListOfFood()
    }

    fun getFoodAt(pos: Int): Food = foodList.value?.get(pos)!!

    fun addFood() {
        repository.addItem()
        getListOfFood()
    }
}