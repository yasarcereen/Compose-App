package com.example.testapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.repository.Repository

class MainViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}

/*override fun <T : ViewModel?> MainViewModelFactory.create(modelClass: Class<T>): T {
    return MainViewModel(repository) as T
}
*/