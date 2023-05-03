package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.repository.Repository
import com.example.testapp.ui.theme.TestAppTheme
import com.example.testapp.ui.views.HomeScreen
import androidx.compose.material3.Surface

class MainActivity: ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        setContent {
            TestAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(myViewModel = viewModel)
                }
            }
        }
    }
}
