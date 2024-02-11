package com.example.canvasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canvasjetpackcompose.ui.theme.CanvasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasJetpackComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    CanvasDrawLine()
                }
            }
        }
    }
}

@Composable
fun CanvasDrawLine() {
    var phase by remember { mutableStateOf(0f) }
    var intervalText by remember { mutableStateOf("") }
    var intervals by remember { mutableStateOf(floatArrayOf(10f, 10f)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LaunchedEffect(intervalText) {
           var iv =  try {
                intervalText.split(",").map {
                    it.toFloat()
                }.toFloatArray()
            } catch (e: Exception) {
                floatArrayOf(10f, 10f)
            }
            if(iv.size>=2){
                intervals = iv
            }else{
                intervals= floatArrayOf(10f,10f)
            }
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(50f, 50f),
                end = Offset(350f, 350f),
                strokeWidth = 30f,
                cap = StrokeCap.Butt,
                alpha = 1f,
                pathEffect = PathEffect.dashPathEffect(
                    intervals,
                    phase
                )
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
        ) {
            TextField(
                value = intervalText,
                onValueChange = {
                    intervalText = it
                }
            )
            Slider(
                value = phase,
                onValueChange = {
                    phase = it
                },
                valueRange = 0f..100f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CanvasPracticePrev() {
    CanvasDrawLine()
}




