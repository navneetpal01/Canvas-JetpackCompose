package com.example.canvasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.canvasjetpackcompose.ui.theme.CanvasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasJetpackComposeTheme {
              Column(
                  modifier = Modifier.fillMaxSize(),
                  horizontalAlignment = Alignment.CenterHorizontally
              ){
                  var value by remember{
                      mutableStateOf(300)
                  }
                  CustomComponent(
                      indicatorValue = value
                  )
                  TextField(
                      value = value.toString(),
                      onValueChange = {
                          value = if (it.isNotEmpty()){
                              it.toInt()
                          } else{
                              0
                          }
                      },
                      keyboardOptions = KeyboardOptions(
                          keyboardType = KeyboardType.Number
                      )
                  )
              }
            }
        }
    }
}


