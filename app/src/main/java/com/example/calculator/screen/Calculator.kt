package com.example.calculator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.CalculatorState
import com.example.calculator.ui.theme.PurpleLight
import com.example.calculator.util.CalculateAction
import com.example.calculator.util.CalculatorOperation


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpace: Dp = 8.dp,
    onAction: (CalculateAction) -> Unit
) {

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpace)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                modifier = Modifier
                    .fillMaxWidth()
                    // .size(20.dp)
                    .padding(vertical = 32.dp),
                textAlign = TextAlign.End,
                fontSize = 80.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                maxLines = 2
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculateAction.Clear)
                    }
                )

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Delete)
                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(color = PurpleLight)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Operation(CalculatorOperation.Division))
                    }
                )

            }

            // Second Row

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(7))
                    }
                )

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(8))
                    }
                )

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(9))
                    }
                )


                CalculatorButton(symbol = "x",
                    modifier = Modifier
                        .background(color = PurpleLight)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }

            // Third Row

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButton(symbol = "4",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(4))
                    })

                CalculatorButton(symbol = "5",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(5))
                    })

                CalculatorButton(symbol = "6",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(6))
                    })

                CalculatorButton(symbol = "-",
                    modifier = Modifier
                        .background(color = PurpleLight)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Operation(CalculatorOperation.Subtraction))
                    }
                )
            }


            // Four Row

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButton(symbol = "1",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(1))
                    })

                CalculatorButton(symbol = "2",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(2))
                    })

                CalculatorButton(symbol = "3",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Number(3))
                    })

                CalculatorButton(symbol = "+",
                    modifier = Modifier
                        .background(color = PurpleLight)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Operation(CalculatorOperation.Addition))
                    }
                )
            }

            //five row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculateAction.Number(0))
                    }
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Decimal)
                    }
                )

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(color = PurpleLight)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculateAction.Calculate)
                    }
                )

            }


        }
    }
}