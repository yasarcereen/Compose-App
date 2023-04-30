package com.example.testapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.model.Product
import com.example.testapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Product> = MutableLiveData()

    fun getProduct() {
        viewModelScope.launch {
            val response: Product = repository.getProduct()
            myResponse.value = response
        }
    }

}