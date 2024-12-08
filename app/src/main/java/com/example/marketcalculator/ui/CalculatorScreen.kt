package com.example.marketcalculator.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.marketcalculator.model.CalculatorViewModel
import com.example.marketcalculator.model.Screen

@Composable
fun CalculatorScreen(
    calculatorViewModel: CalculatorViewModel = viewModel(),
    onSaveProduct: (String, Double) -> Unit,
    onViewProducts: () -> Unit,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título da calculadora
        Text(
            text = "Calculadora",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Exibe o display da calculadora com fallback em caso de estado nulo
        CalculatorDisplay(
            modifier = Modifier.weight(1f),
            displayText = calculatorViewModel.displayText.value ?: "0"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botões da calculadora
        CalculatorButtons(
            onNumberClick = calculatorViewModel::handleNumberClick,
            onOperatorClick = calculatorViewModel::handleOperatorClick,
            onEqualsClick = calculatorViewModel::handleEqualsClick,
            onClearClick = calculatorViewModel::handleClearClick,
            onBackspaceClick = calculatorViewModel::handleBackspaceClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ações adicionais: salvar produto e visualizar produtos salvos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                // Substitua por lógica real de salvar produto
                onSaveProduct("Produto Exemplo", 99.99)
                navController.navigate(Screen.SavedProducts.route) // Navega para a tela de produtos salvos
            }) {
                Text("Salvar Produto")
            }

            Button(onClick = onViewProducts) {
                Text("Produtos Salvos")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    val navController = rememberNavController()
    val fakeViewModel = object : CalculatorViewModel() {
        @SuppressLint("UnrememberedMutableState")
        override var displayText = mutableStateOf("123 + 456")
    }

    CalculatorScreen(
        calculatorViewModel = fakeViewModel,
        onSaveProduct = { _, _ -> },
        onViewProducts = {},
        navController = navController
    )
}






//@Composable
//fun CalculatorScreen(
//    onSaveProduct: (Any?, Any?) -> Unit,
//    onViewProducts: () -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Calculadora",
//            style = MaterialTheme.typography.bodyMedium,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        CalculatorDisplay(
//            modifier = Modifier.weight(1f)
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        CalculatorButtons(
//            onNumberClick = { /* TODO: Handle Number Click */ },
//            onOperatorClick = { /* TODO: Handle Operator Click */ },
//            onEqualsClick = { /* TODO: Handle Equals */ },
//            onClearClick = { /* TODO: Handle Clear */ }
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Button(onClick = { onSaveProduct("Produto", 0.0) }) {
//                Text("Salvar Produto")
//            }
//            Button(onClick = onViewProducts) {
//                Text("Produtos Salvos")
//            }
//        }
//    }
//}