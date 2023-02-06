package com.example.menufood

import androidx.annotation.DrawableRes

data class Food(var name: String, var price: Float, @DrawableRes var imgUrl: Int)