package com.example.testapp

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.model.Product
import com.example.testapp.repository.Repository
import com.example.testapp.ui.theme.TestAppTheme
import coil.compose.rememberAsyncImagePainter
import com.example.testapp.model.ResponseStorage
import androidx.compose.foundation.lazy.items

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

@Composable
fun HomeScreen(myViewModel: MainViewModel) {
    myViewModel.getProduct()
    val myData by myViewModel.myResponse.observeAsState()

    myData?.let { ProductBox(myData = it) }
}

@Composable
fun ProductBox(myData: ResponseStorage) {
    val products: List<Product> = myData?.products ?: listOf()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(products) { product ->
            SingleProduct(product)
        }
    }

}

@Composable
fun SingleProduct(product: Product) {
    Column(modifier = Modifier.padding(all = 10.dp)) {

        Surface(
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 1.5.dp
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.thumbnail),
                contentDescription = null,
                modifier = Modifier.aspectRatio(16f / 9f),
                contentScale = ContentScale.FillHeight
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Row(
            modifier = Modifier
                .padding(all = 5.dp)
                .widthIn(0.dp, 232.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                product.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(4.dp, end = 25.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.End
            )

            Column(modifier = Modifier.padding(all = 2.5.dp)) {
                Text(
                    "Price: ${product.price}$",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(2.dp),
                    textAlign = TextAlign.Left
                )
                Text(
                    "Rating: ${product.rating}/5",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(2.dp),
                    textAlign = TextAlign.Left
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            product.description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

/*@Preview
@Composable
fun PreviewProductBox() {
    TestAppTheme {
        ProductBox(
            listOf(
                Product(1,"title1","description1",50.0,
            5.4,3.7,10,"brand1","cat1","https://i.dummyjson.com/data/products/1/thumbnail.jpg",
                arrayListOf())
            )
        )
    }
}*/