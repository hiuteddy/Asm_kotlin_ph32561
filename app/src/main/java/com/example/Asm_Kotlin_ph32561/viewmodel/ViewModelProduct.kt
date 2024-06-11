package com.example.Asm_Kotlin_ph32561.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Asm_Kotlin_ph32561.repository.ProductResponse
import com.example.Asm_Kotlin_ph32561.service.RetrofitInstance
import kotlinx.coroutines.launch

class ViewModelProduct: ViewModel() {

    private val _listProduct = mutableStateOf<List<ProductResponse>>(emptyList())
    val listProduct: State<List<ProductResponse>> = _listProduct

    fun listProductViewModel(cateID: String?) {
        viewModelScope.launch {
            try {
                _listProduct.value = RetrofitInstance.apiService.getProducts(cateID)
                Log.d("TAG", "thanhcong: ${_listProduct.value}")
            } catch (e: Exception) {
                Log.d("TAG", "thatbai: ${e.message}")
            }
        }
    }

    private val _detailProduct = mutableStateOf<ProductResponse?>(null)
    val detailProduct: State<ProductResponse?> = _detailProduct

    fun detailProductViewModel(productId: String?) {
        viewModelScope.launch {
            try {
                _detailProduct.value = RetrofitInstance.apiService.getProductByID(productId)
                Log.d("TAG", "thanhcong: ${_detailProduct.value}")
            } catch (e: Exception) {
                Log.d("TAG", "thatbai: ${e.message}")
            }
        }
    }


    fun searchProductViewModel(keyword: String) {
        viewModelScope.launch {
            try {
                _listProduct.value = RetrofitInstance.apiService.searchProducts(keyword)
                Log.d("TAG", "Search successful: $_listProduct.value")
            } catch (e: Exception) {
                Log.d("TAG", "Search failed: ${e.message}")
            }
        }
    }


}