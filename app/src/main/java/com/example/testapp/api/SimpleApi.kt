package com.example.testapp.api

import com.example.testapp.model.Product
import retrofit2.http.GET

interface SimpleApi {
    @GET("/product/1")
    suspend fun getProduct(): Product
}