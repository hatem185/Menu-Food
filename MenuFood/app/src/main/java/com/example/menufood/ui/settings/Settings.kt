package com.example.menufood.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.menufood.R
import com.example.menufood.databinding.FragmentSettingsBinding
import com.example.menufood.model.SharedPref


class Settings : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val FONT_SIZE = "font_size"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        binding.apply {
            when (SharedPref(requireContext()).getFontSize()) {
                38f -> largeSize.isChecked = true
                28f -> meduimSize.isChecked = true
                18f -> smallSize.isChecked = true
                else -> fontSizeGroup.clearCheck()
            }
            saveBtn.setOnClickListener { changeFontSizeHandler() }
        }
    }

    private fun changeFontSizeHandler() {
        SharedPref(requireContext()).apply {
            saveFontSize(
                when {
                    binding.largeSize.isChecked -> 38f
                    binding.meduimSize.isChecked -> 28f
                    binding.smallSize.isChecked -> 18f
                    else -> 16f
                }
            )
            Toast.makeText(context, "The text size is change!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
