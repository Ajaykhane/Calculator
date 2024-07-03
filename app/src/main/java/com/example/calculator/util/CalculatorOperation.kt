package com.example.calculator.util

sealed class CalculatorOperation(val symbol : String) {
     object Addition : CalculatorOperation("+")
     object Subtraction : CalculatorOperation("-")
     object Multiply : CalculatorOperation("x")
     object Division : CalculatorOperation("/")


}
