package com.example.boaviagem

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.boaviagem.ui.theme.BoaViagemTheme

class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoaViagemTheme {
                val user = intent.getStringExtra("user") ?: "Usuário Desconhecido"
                UserGreeting(user)
            }
        }
    }
}

@Composable
fun UserGreeting(name: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = "Seja bem-vindo $name!", style = MaterialTheme.typography.headlineMedium)
    }
}