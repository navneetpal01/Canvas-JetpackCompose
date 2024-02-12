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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
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
            /*
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
            ) */

           /* drawCircle(
                color = Color.Blue,
                radius = 50f,
                center = Offset(150f,150f),
                alpha = 1f,
                style = Stroke(
                    width = 6f,
                    pathEffect = PathEffect.dashPathEffect(
                        intervals,
                        phase
                    )
                ),
            )
            */
            /*
            drawOval(
                color = Color.Blue,
                topLeft = Offset(50f,50f),
                size = Size(100f,200f)
            )*/
            /*
            drawRect(
                color = Color.Black,
                topLeft = Offset(100f,50f),
                size = Size(200f,150f),
                
            )
            */
            /*
            drawArc(
                color = Color.Black,
                startAngle = 30f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(100f,100f),
                size = Size(150f,200f),
                style = Stroke(
                    width = 10f
                )
            )
             */
            /*
            drawRoundRect(
                color = Color.Blue,
                topLeft = Offset(100f,50f),
                size = Size(100f,200f),
                cornerRadius = CornerRadius(
                    x = 10f,
                    y = 60f
                ),
                style = Stroke(
                    20f,

                )
            )
           */
            /*
            drawPath(
                color = Color.Black,
                path = Path().apply {
                    moveTo(100f,100f)
                    lineTo(150f,200f)
                    lineTo(0f,40f)
                    addRect(Rect(
                        Offset(100f,150f),
                        Size(150f,200f)
                    ))
                },
                style = Stroke(
                    10f,

                )
            )
            */
            /*
            rotate(
                degrees = 190f,
                pivot = Offset(150f,250f)
            ){
                drawRect(
                    brush = Brush.horizontalGradient(
                        Pair(0f, Color.Black),
                        Pair(0.5f, Color.Blue),
                        Pair(1f,Color.Red),
                        startX = 100f,
                        endX = 200f
                    ),
                    topLeft = Offset(100f,150f),
                    size = Size(100f,200f),

                    )
            }
             */
            /*
            scale(
                scaleX = 3f,
                scaleY = 3f,
                pivot = Offset(150f,250f)
            ){
                drawRect(
                    brush = Brush.horizontalGradient(
                        Pair(0f, Color.Black),
                        Pair(0.5f, Color.Blue),
                        Pair(1f,Color.Red),
                        startX = 100f,
                        endX = 200f
                    ),
                    topLeft = Offset(100f,150f),
                    size = Size(100f,200f),

                    )
            }
             */
            rotate(
                45f,
                pivot = Offset(150f,250f)
            ) {
                translate(
                    left = 300f,
                    top = 400f
                ) {
                    drawRect(
                        brush = Brush.horizontalGradient(
                            Pair(0f, Color.Black),
                            Pair(0.5f, Color.Blue),
                            Pair(1f, Color.Red),
                            startX = 100f,
                            endX = 200f
                        ),
                        topLeft = Offset(100f, 150f),
                        size = Size(100f, 200f),

                        )
                }
            }

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




