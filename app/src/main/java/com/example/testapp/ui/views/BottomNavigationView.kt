package com.example.testapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.ui.theme.TestAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun BottomNavigation() {
    Surface {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(start = 45.dp, end = 45.dp, top = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween){

            FaIcon(faIcon = FaIcons.Heart, size = 30.dp)
            FaIcon(faIcon = FaIcons.Home, size = 30.dp)
            FaIcon(faIcon = FaIcons.ShoppingCart, size = 30.dp)
            FaIcon(faIcon = FaIcons.User, size = 30.dp)
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    TestAppTheme {
        BottomNavigation()
    }
}
