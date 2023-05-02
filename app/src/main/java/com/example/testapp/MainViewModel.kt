package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.model.ResponseStorage
import com.example.testapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: LiveData<ResponseStorage> = MutableLiveData()

    fun getProduct() {
        viewModelScope.launch {
            val response:  ResponseStorage = repository.getProduct()

            (myResponse as MutableLiveData).value = response
        }
    }
}
