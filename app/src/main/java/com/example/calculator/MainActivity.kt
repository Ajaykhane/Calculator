package com.example.calculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.screen.Calculator
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.viewModel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {


                    val viewModel = viewModel<CalculatorViewModel>()
                    val state = viewModel.state
                    val buttonSpacing = 8.dp


                    Calculator(
                        state = state,
                        onAction = viewModel::onAction,
                        buttonSpace = buttonSpacing,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Black)
                            .padding(16.dp))
                }
            }
        }
    }
}
