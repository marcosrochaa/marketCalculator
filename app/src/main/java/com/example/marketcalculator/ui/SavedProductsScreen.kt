package com.example.marketcalculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marketcalculator.extensions.formatPrice
import com.example.marketcalculator.extensions.formatData
import com.example.marketcalculator.model.Product

@Composable
fun SavedProductsScreen(
    products: List<Product>,
    totalPrice: Double, // Passando o preço total como parâmetro
    onBackClick: () -> Unit,
    onDeleteProduct: (Product) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Produtos Salvos",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            if (products.isNotEmpty()) {
                items(products) { product ->
                    ProductItem(product = product, onDeleteProduct = onDeleteProduct)
                    Divider()
                }
            } else {
                item {
                    Text("Nenhum produto salvo", modifier = Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }

        // Barra de preço total
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total: R$ ${"%.2f".format(totalPrice)}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Button(onClick = onBackClick) {
                Text("Voltar")
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onDeleteProduct: (Product) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = product.name, style = MaterialTheme.typography.headlineMedium)
            Text(
                text = "Preço: R$ ${product.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Data: ${product.purchaseDate}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        IconButton(onClick = { onDeleteProduct(product) }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir Produto")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedProductsScreenPreview() {
    val sampleProducts = listOf(
        Product(name = "Arroz", price = 19.99, purchaseDate = "06/12/2024"),
        Product(name = "Feijão", price = 7.49, purchaseDate = "06/12/2024"),
        Product(name = "Óleo", price = 5.99, purchaseDate = "05/12/2024")
    )
    SavedProductsScreen(
        products = sampleProducts,
        totalPrice = sampleProducts.sumOf { it.price },
        onBackClick = {},
        onDeleteProduct = {}
    )
}


