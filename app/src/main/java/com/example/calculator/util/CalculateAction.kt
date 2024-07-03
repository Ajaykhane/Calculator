package com.example.calculator.util

sealed class CalculateAction{
    data class Number(val number : Int): CalculateAction()
     object Clear : CalculateAction()
     object Delete : CalculateAction()
     object Decimal : CalculateAction()
     object Calculate : CalculateAction()
    data class Operation(val operation : CalculatorOperation) : CalculateAction()
}
