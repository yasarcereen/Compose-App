package com.example.testapp.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testapp.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(myViewModel: MainViewModel) {
    myViewModel.getProduct()
    val myData by myViewModel.myResponse.observeAsState()

    Scaffold(bottomBar = { BottomNavigation() }) {padding ->
        Modifier.padding(1.dp)

        myData?.let { ProductBox(myData = it) }
    }
}
