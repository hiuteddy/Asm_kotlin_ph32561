package com.example.Asm_Kotlin_ph32561.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Asm_Kotlin_ph32561.repository.CategoryResponse
import com.example.Asm_Kotlin_ph32561.service.RetrofitInstance
import kotlinx.coroutines.launch

class ViewModelCategory:ViewModel() {

    private val _categories = mutableStateOf<List<CategoryResponse>>(emptyList())
    val categories: State<List<CategoryResponse>> = _categories

    fun categoryViewModel() {
        viewModelScope.launch {
            try {
                _categories.value = RetrofitInstance.apiService.getCategories()
                Log.d("TAG", "thanhcong: ${_categories.value}")
            } catch (e: Exception) {
                Log.d("TAG", "thatbai: ${e.message}")
            }
        }
    }
}