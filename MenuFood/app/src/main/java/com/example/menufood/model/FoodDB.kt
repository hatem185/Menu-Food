package com.example.menufood.model

import com.example.menufood.ui.food.Food

interface FoodDB {
    fun getFoodList(): List<Food>
    fun removeItem()
    fun addItem()
}