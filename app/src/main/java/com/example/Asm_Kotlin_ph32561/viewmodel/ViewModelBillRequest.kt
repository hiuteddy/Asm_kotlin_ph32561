package com.example.Asm_Kotlin_ph32561.viewmodel


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Asm_Kotlin_ph32561.repository.BiillDetails
import com.example.Asm_Kotlin_ph32561.repository.ProductResponse
import com.example.Asm_Kotlin_ph32561.request.BillRequest
import com.example.Asm_Kotlin_ph32561.repository.Response
import com.example.Asm_Kotlin_ph32561.service.ApiService
import com.example.Asm_Kotlin_ph32561.service.RetrofitInstance
import com.example.Asm_Kotlin_ph32561.service.RetrofitInstance.apiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelBillRequest : ViewModel() {

    private val _billResponse = MutableStateFlow<List<BiillDetails>?>(null)
    val billResponse: StateFlow<List<BiillDetails>?> = _billResponse.asStateFlow()

    private val _productResponse = MutableStateFlow<List<ProductResponse>>(emptyList())
    val productResponse: StateFlow<List<ProductResponse>> = _productResponse.asStateFlow()

    fun addBillViewModel(productID: String, quantity: Int) {
        viewModelScope.launch {
            try {
                val request = BillRequest(productID, quantity)
                val response = apiService.addBill(request)
                Log.d("TAG", "Thêm bill thành công: $response")
            } catch (e: Exception) {
                Log.d("TAG", "Thêm bill thất bại: ${e.message}")
            }
        }
    }

    fun getBills() {
        viewModelScope.launch {
            try {
                _billResponse.value = apiService.getBills()
            } catch (e: Exception) {
                Log.e("ViewModelBillRequest", "Failed to fetch bills", e)
            }
        }
    }

    private suspend fun getProductsByIds(productIds: List<String>): List<ProductResponse> {
        val products = mutableListOf<ProductResponse>()
        for (productId in productIds) {
            val product = apiService.getProductByID(productId)
            product?.let { products.add(it) }
        }
        return products
    }

    fun getProductsFromBills() {
        viewModelScope.launch {
            try {
                val bills = _billResponse.value ?: return@launch
                val productIds = bills.map { it.productID }
                val products = getProductsByIds(productIds)
                _productResponse.value = products
            } catch (e: Exception) {
                Log.e("ViewModelBillRequest", "Failed to fetch products", e)
            }
        }
    }
}
