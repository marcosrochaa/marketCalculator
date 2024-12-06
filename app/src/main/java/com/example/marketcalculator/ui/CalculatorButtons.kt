package com.example.marketcalculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorButtons(
    onNumberClick: (Int) -> Unit,
    onOperatorClick: (String) -> Unit,
    onEqualsClick: () -> Unit,
    onClearClick: () -> Unit
) {
    Column {
        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("C", "0", "=", "+")
        )
        buttons.forEach { row ->
            Row(modifier = Modifier.fillMaxWidth()) {
                row.forEach { button ->
                    Button(
                        onClick = {
                            when (button) {
                                "C" -> onClearClick()
                                "=" -> onEqualsClick()
                                in listOf("+", "-", "*", "/") -> onOperatorClick(button)
                                else -> onNumberClick(button.toInt())
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text(button)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorButtons() {
    CalculatorButtons(
        onNumberClick = { number -> /* No-op for preview */ },
        onOperatorClick = { operator -> /* No-op for preview */ },
        onEqualsClick = { /* No-op for preview */ },
        onClearClick = { /* No-op for preview */ }
    )
}
