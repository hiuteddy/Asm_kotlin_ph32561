package com.example.Asm_Kotlin_ph32561.service

import com.example.Asm_Kotlin_ph32561.repository.BiillDetails
import com.example.Asm_Kotlin_ph32561.repository.CategoryResponse
import com.example.Asm_Kotlin_ph32561.repository.ProductResponse
import com.example.Asm_Kotlin_ph32561.repository.Response
import com.example.Asm_Kotlin_ph32561.request.BillRequest
import com.example.Asm_Kotlin_ph32561.request.LoginRequest
import com.example.Asm_Kotlin_ph32561.request.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

//import fpoly.giapdqph34273.asm_ph34273_kot104.request.LoginRequest
//import fpoly.giapdqph34273.asm_ph34273_kot104.request.RegisterRequest
//import fpoly.giapdqph34273.testloginapi.response.Response
interface ApiService {
    @POST("register")
    suspend fun register(@Body registerReq: RegisterRequest): Response?

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response?

    @GET("categories")
    suspend fun getCategories(): List<CategoryResponse>

    @GET("products")
    suspend fun getProducts(@Query("cateID") cateID: String?): List<ProductResponse>
    //
    @GET("get-product-by-id/{productID}")
    suspend fun getProductByID(@Path("productID") productID: String?): ProductResponse?

    @GET("get-product-by-id/{productID}")
    suspend fun getProductByID1(@Path("productID") productID: String?): List<ProductResponse> // <-- Thay đổi ở đây

// Trong ApiService.j
    @GET("search-products")
    suspend fun searchProducts(@Query("keyword") keyword: String): List<ProductResponse>

    @POST("addBill")
    suspend fun addBill(@Body addBillRequest: BillRequest): Response?

    @GET("getBill")
    suspend fun getBills(): List<BiillDetails>

}