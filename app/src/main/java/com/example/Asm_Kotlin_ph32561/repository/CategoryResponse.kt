package com.example.Asm_Kotlin_ph32561.repository

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("_id") val cateID: String,
    val cateName: String,
    val image: String
)
