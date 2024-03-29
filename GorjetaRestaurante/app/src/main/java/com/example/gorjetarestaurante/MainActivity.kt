package com.example.gorjetarestaurante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gorjetarestaurante.ui.theme.GorjetaRestauranteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcularGorjeta()
        }
    }
}

@Composable
fun CalcularGorjeta() {
    var total = remember { mutableStateOf("") }
    var valorPersonalizado = remember { mutableStateOf(18f) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Calculadora de Gorjetas", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = total.value,
                onValueChange = {
                    total.value = it
                },
                label = { Text("Valor Adquirido") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text("Personalizado %: ${valorPersonalizado.value.toInt()}%")
            Slider(
                value = valorPersonalizado.value,
                onValueChange = { valorPersonalizado.value = it },
                valueRange = 0f..30f
            )
            Spacer(modifier = Modifier.height(16.dp))

            val valorGorjeta = total.value.toDoubleOrNull() ?: 0.0
            val padrao = valorGorjeta * 0.15
            val gorjetaPersonalizada = valorGorjeta * (valorPersonalizado.value / 100)
            Text("Gorjeta 15%: $${"%.2f".format(padrao)}")
            Text("Gorjeta Personalizada: $${"%.2f".format(gorjetaPersonalizada)}")
            Text("Total 15%: $${"%.2f".format(valorGorjeta + padrao)}")
            Text("Total Personalizado: $${"%.2f".format(valorGorjeta + gorjetaPersonalizada)}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GorjetaRestauranteTheme {
        CalcularGorjeta()
    }
}