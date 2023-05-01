package com.example.testapp.api

import com.example.testapp.model.ResponseStorage
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    @GET("/product")
    suspend fun getProduct(): ResponseStorage
}