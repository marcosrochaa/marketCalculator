package com.example.marketcalculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    onNumberClick: (String) -> Unit,
    onOperatorClick: (String) -> Unit,
    onEqualsClick: () -> Unit,
    onClearClick: () -> Unit,
    onBackspaceClick: () -> Unit
) {
    Column {
        // Números e Operações
        val rows = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", ".", "=", "+")
        )

        rows.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { buttonText ->
                    Button(
                        onClick = {
                            when (buttonText) {
                                "=" -> onEqualsClick()
                                "/" -> onOperatorClick("/")
                                "*" -> onOperatorClick("*")
                                "-" -> onOperatorClick("-")
                                "+" -> onOperatorClick("+")
                                else -> onNumberClick(buttonText)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(buttonText)
                    }
                }
            }
        }

        // Botões de apagar (C e Backspace)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onClearClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("C") // Limpar tudo
            }

            Button(
                onClick = onBackspaceClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("←") // Apagar um caractere
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCalculatorButtons() {
    CalculatorButtons(
        onNumberClick = { /* Lógica para número clicado */ },
        onOperatorClick = { /* Lógica para operador clicado */ },
        onEqualsClick = { /* Lógica para igual clicado */ },
        onClearClick = { /* Lógica para limpar tudo */ },
        onBackspaceClick = { /* Lógica para apagar um caractere */ }
    )
}

