package com.example.testapp.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testapp.model.Product
import com.example.testapp.model.ResponseStorage
import com.example.testapp.ui.theme.TestAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

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
    Surface(shape = MaterialTheme.shapes.large,
        shadowElevation = 2.dp,
        modifier = Modifier.padding(5.dp)) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.5.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(product.thumbnail),
                    contentDescription = product.description,
                    modifier = Modifier.aspectRatio(16f / 9f),
                    contentScale = ContentScale.FillHeight
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Title & Price
            Row (modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    product.title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    FaIcon(faIcon = FaIcons.Tag, size = 16.dp)
                    Text(
                        "${product.price}$",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

            // Rating & Add to Cart
            Row (modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                Row{
                    FaIcon(faIcon = FaIcons.Star, size = 16.dp)
                    Text("${product.rating}/5",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 5.dp),
                        //.align(Alignment.End),
                        textAlign = TextAlign.Left
                    )
                }
                FaIcon(faIcon = FaIcons.ShoppingCart, size = 20.dp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewProductBox() {
    val rs = ResponseStorage(listOf(
        Product(1,"title1","description1",50.0,
            5.4,3.7,10,"brand1","cat1","https://i.dummyjson.com/data/products/1/thumbnail.jpg",
            arrayListOf())
    ), 100, 0, 30)
    TestAppTheme {
        ProductBox(rs)
    }
}