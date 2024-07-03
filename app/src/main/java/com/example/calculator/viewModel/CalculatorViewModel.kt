package com.example.calculator.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.CalculatorState
import com.example.calculator.util.CalculateAction
import com.example.calculator.util.CalculatorOperation


class CalculatorViewModel : ViewModel() {
    // Mutable Means value can be change in other hand immutable value can bc change.
    var state by mutableStateOf(CalculatorState())
        private set


    @RequiresApi(Build.VERSION_CODES.O)
    fun onAction(action: CalculateAction) {
        when (action) {
            is CalculateAction.Number -> enterNumber(action.number)
            is CalculateAction.Calculate -> calculate()
            is CalculateAction.Clear -> state = CalculatorState()
            is CalculateAction.Decimal -> enterDecimal()
            is CalculateAction.Delete -> delete()
            is CalculateAction.Operation -> enterOperation(action.operation)

        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() ->
                state = state.copy(
                    number2 = state.number2.dropLast(1)
                )

            state.operation != null ->
                state = state.copy(
                    operation = null
                )

            state.number1.isNotBlank() ->
                state = state.copy(
                    number1 = state.number1.dropLast(1)
                )

        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                CalculatorOperation.Addition -> number1 + number2
                CalculatorOperation.Division -> number1 / number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Subtraction -> number1 - number2
                null -> return

            }
            state = state.copy(
                number1 = result.toString().take(14),
                number2 = "",
                operation = null
            )
        }
    }
    private fun enterDecimal() {
        if (state.number1.isNotBlank()  &&
            !state.number1.contains(".") &&
            state.operation == null
        ) {

            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (state.number2.isNotBlank()  &&
            !state.number2.contains(".")
        ) {

            state = state.copy(number2 = state.number2 + ".")
            return
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(
                operation = operation
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= Max_Length) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number)
            return

        }
        if (state.number2.length >= Max_Length) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )



    }

    companion object {
        private const val Max_Length = 9
    }
}


