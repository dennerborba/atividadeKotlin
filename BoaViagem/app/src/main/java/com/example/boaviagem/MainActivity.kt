package com.example.boaviagem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boaviagem.ui.theme.BoaViagemTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoaViagemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaLogin()
                }
            }
        }
    }
}

@Composable
fun TelaLogin() {
    val context = LocalContext.current
    val user = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bahamas),
            contentDescription = "paisagem",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(bottom = 14.dp)
        )
        Text("Acesse sua conta", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = user.value,
            onValueChange = { user.value = it },
            label = { Text(text = "Usuário") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Senha") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (user.value == "jonas" && password.value == "1234") {
                    val intent = Intent(context, UserActivity::class.java).apply {
                        putExtra("user", user.value)
                    }
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Erro ao efetuar login", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(text = "Logar")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewTelaLogin() {
    BoaViagemTheme {
        TelaLogin()
    }
}