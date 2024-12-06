package com.example.marketcalculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorDisplay(
    displayText: String, // Corrigido: o parâmetro displayText estava faltando
    modifier: Modifier = Modifier
) {
    Text(
        text = displayText,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier.fillMaxWidth().padding(16.dp),
        textAlign = TextAlign.End
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorDisplay() {
    CalculatorDisplay(displayText = "123 + 456", modifier = Modifier.fillMaxWidth())
}