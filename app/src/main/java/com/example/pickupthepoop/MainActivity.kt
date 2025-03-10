package com.example.pickupthepoop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pickupthepoop.ui.theme.PickUpThePoopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PickUpThePoopTheme {
                SickDog(modifier = Modifier.fillMaxSize()
                    .wrapContentSize(align = Alignment.Center))
            }
        }
    }
}

@Composable
fun SickDog(modifier: Modifier = Modifier) {
    var numTapSickDog by remember { mutableStateOf(2) }

    Column(modifier = modifier) {
        Image(stringResource())
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PickUpThePoopTheme {
//        Greeting("Android")
//    }
//}