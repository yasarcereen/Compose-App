package com.example.testapp.ui.views

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testapp.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBar(products: List<Product>) {
    val context = LocalContext.current

    val categories: MutableSet<String> = mutableSetOf()
    //val productsByCategories: MutableMap<String, ArrayList<Product>> = mutableMapOf()

    products.forEach {
        categories += it.category
        //productsByCategories[it.category]?.add(it)
    }

    categories += "All"

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Filter by category") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.5.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            TextField(
                value = selectedText,
                onValueChange = {

                },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categories.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

/*@Preview
@Composable
fun PreviewFilterBar() {
    TestAppTheme {
        FilterBar()
    }
}*/