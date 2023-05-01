package com.example.testapp.repository

import com.example.testapp.api.RetrofitInstance
import com.example.testapp.model.ResponseStorage
import retrofit2.Call

class Repository {
    suspend fun getProduct(): ResponseStorage {
        return RetrofitInstance.api.getProduct()
    }
}