package com.example.testapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.model.Product
import com.example.testapp.model.ResponseStorage
import com.example.testapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<ResponseStorage> = MutableLiveData()

    fun getProduct() {
        viewModelScope.launch {
            val response:  ResponseStorage = repository.getProduct()

            myResponse.value = response



            /*response.enqueue(object: Callback<ResponseStorage?> {
                override fun onResponse(call: Call<ResponseStorage?>, response: Response<ResponseStorage?>) {
                    val responseBody = response.body()!!

                    myResponse.value = responseBody.productList
                }
                override fun onFailure(call: Call<ResponseStorage?>, t: Throwable) {
                    println("HATA")
                }
            })*/

            //myResponse.value = response
        }
    }
}
