package com.example.marketcalculator.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class CalculatorViewModel : ViewModel() {
    open var displayText = mutableStateOf("0")
    private var currentInput = ""
    private var previousInput = ""
    private var operator = ""

    fun handleNumberClick(number: String) {
        // Se o display estiver 0, substitui pelo número pressionado
        if (displayText.value == "0") {
            currentInput = number
        } else {
            currentInput += number
        }
        displayText.value = currentInput
    }

    fun handleOperatorClick(operator: String) {
        // Armazena o valor atual e o operador
        if (previousInput.isNotEmpty()) {
            calculate()
        }
        previousInput = currentInput
        this.operator = operator
        currentInput = ""
    }

    fun handleEqualsClick() {
        calculate()
    }

    private fun calculate() {
        val firstNumber = previousInput.toDoubleOrNull() ?: return
        val secondNumber = currentInput.toDoubleOrNull() ?: return

        val result = when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> return
        }
        displayText.value = result.toString()
        currentInput = result.toString()
        previousInput = ""
        operator = ""
    }

    fun handleClearClick() {
        displayText.value = "0"
        currentInput = ""
        previousInput = ""
        operator = ""
    }

    fun handleBackspaceClick() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            displayText.value = if (currentInput.isEmpty()) "0" else currentInput
        }
    }
}

