package com.example.Asm_Kotlin_ph32561.repository

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("_id") val productID: String,
    val productName: String,
    val price: Int,
    val image: String,
    val description: String,
    val cateID: String
)