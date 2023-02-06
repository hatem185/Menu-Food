package com.example.menufood

import android.content.Context

class SharedPref(context: Context) {
    companion object {
        private const val FILE_KEY = "app_setting"
    }
    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)
    fun saveFontSize(fontSize: Float) =
        sharedPref.edit().putFloat(Settings.FONT_SIZE, fontSize).apply()
    fun getFontSize(): Float = sharedPref.getFloat(Settings.FONT_SIZE, 16f)

}