package com.example.testapp.repository

import com.example.testapp.api.RetrofitInstance
import com.example.testapp.model.Product

class Repository {
    suspend fun getProduct(): Product {
        return RetrofitInstance.api.getProduct()
    }
}