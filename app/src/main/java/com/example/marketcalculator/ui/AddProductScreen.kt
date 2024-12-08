package com.example.marketcalculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marketcalculator.model.Product

@Composable
fun AddProductScreen(
    onSaveProduct: (Product) -> Unit,
    onCancel: () -> Unit
) {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Cadastrar Produto",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de Nome do Produto
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Nome do Produto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Preço
        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text("Preço") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Data de Compra
        OutlinedTextField(
            value = productDate,
            onValueChange = { productDate = it },
            label = { Text("Data de Compra") },
            placeholder = { Text("dd/MM/yyyy") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botões de Salvar e Cancelar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onCancel) {
                Text("Cancelar")
            }

            Button(
                onClick = {
                    if (productName.isNotBlank() && productPrice.isNotBlank() && productDate.isNotBlank()) {
                        val price = productPrice.toDoubleOrNull()
                        if (price != null) {
                            val product = Product(
                                name = productName,
                                price = price,
                                purchaseDate = productDate
                            )
                            onSaveProduct(product)
                        } else {
                            // Exibe uma mensagem de erro para preço inválido
                        }
                    } else {
                        // Exibe uma mensagem de erro para campos em branco
                    }
                }
            ) {
                Text("Salvar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview() {
    AddProductScreen(
        onSaveProduct = { product ->
            // Simula o que acontece quando o produto é salvo
            println("Produto salvo: $product")
        },
        onCancel = {
            // Simula o cancelamento da ação
            println("Ação de cancelamento")
        }
    )
}




//@Composable
//fun AddProductScreen(
//    onSaveProduct: (Product) -> Unit,
//    onCancel: () -> Unit
//) {
//    var productName by remember { mutableStateOf("") }
//    var productPrice by remember { mutableStateOf("") }
//    var productDate by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        TextField(
//            value = productName,
//            onValueChange = { productName = it },
//            label = { Text("Nome do Produto") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        TextField(
//            value = productPrice,
//            onValueChange = { productPrice = it },
//            label = { Text("Preço") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        TextField(
//            value = productDate,
//            onValueChange = { productDate = it },
//            label = { Text("Data de Compra") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Button(onClick = onCancel) { Text("Cancelar") }
//            Button(onClick = {
//                val price = productPrice.toDoubleOrNull() ?: 0.0
//                if (productName.isNotBlank() && price > 0 && productDate.isNotBlank()) {
//                    onSaveProduct(Product(productName, price, productDate))
//                }
//            }) { Text("Salvar") }
//        }
//    }
//}
