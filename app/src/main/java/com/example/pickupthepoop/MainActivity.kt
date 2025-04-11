package com.example.pickupthepoop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pickupthepoop.ui.theme.PickUpThePoopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PickUpThePoopTheme {
                SickDog(modifier = Modifier)
            }
        }
    }
}

@Composable
fun SickDog(modifier: Modifier = Modifier) {
    var numTapSickDog by remember { mutableStateOf((2..5).random()) }
    var step by remember { mutableStateOf(1) }
    var tapNum by remember { mutableStateOf(0) }
    val context = LocalContext.current

    when (step)
    {
        1 -> {
            ImageAndText(
                buttonClick = {
                    tapNum += 1
                    if (tapNum == numTapSickDog) {
                        step++
                    }
                    else if (tapNum == 1 || tapNum > numTapSickDog) {
                        numTapSickDog = (2..5).random()
                    }
                },
                R.drawable.sick_dog,
                step.toString(),
                R.string.sick_dog,
            )
        }
        2 -> {
            ImageAndText(
                buttonClick = {
                    step++
                },
                context.resources.getIdentifier("poop" + (1..6).random().toString(),
                "drawable", context.packageName),
                step.toString(),
                R.string.pick_up,
            )
        }
        3 -> {
            ImageAndText(
                buttonClick = {
                    //step++
                },
                R.drawable.happy_dog,
                step.toString(),
                R.string.happy_dog,
            )
       }
//        else -> {
//            ImageAndText(
//                buttonClick = {
//                    step = 1
//                },
//                R.drawable.dead_dog,
//                step.toString(),
//                R.string.dead_dog,
//            )
//        }
    }
}

@Composable
fun ImageAndText(buttonClick: () -> Unit, painter: Int, step: String, text: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(16.dp))
                .size(300.dp)
                .background(MaterialTheme.colorScheme.primary)
                .padding(20.dp),
            onClick = buttonClick
        ) {
            Image(
                painter = painterResource(painter),
                contentDescription = step
            )
        }

        Text(
            text = stringResource(text)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PickUpThePoopTheme {
//        Greeting("Android")
//    }
//}