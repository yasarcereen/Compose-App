package com.example.testapp.model

data class ResponseStorage (
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
    )