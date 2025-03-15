package com.maestrocorona.appferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrocorona.appferia.ui.theme.AppFeriaTheme


// Agregamos los colores para el Fondo Claro y Oscuro

private val purple40 = Color(color = 0xFF6650a4)
private val purple80 = Color(color = 0xFFD0BCFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                // Iniciamos la segunda actividad cuando se presione el botón
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    // Pantalla principal que contiene todos los elementos
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Lista de negocios con sus imágenes

            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")

            // Se agrego la cuarta card de Atracciones y Conciertos
            BusinessItem("Atracciones Y Conciertos")


            // Botón para navegar a la segunda actividad
            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes")
            }
        }
    }
}

@Composable
fun BusinessItem(text: String) {
    // Componente reutilizable para mostrar negocio con imagen
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
            shape = RoundedCornerShape(16.dp),

            // Se Cambia el color de las Card
            colors = CardDefaults.cardColors(
                containerColor = purple80
            )

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del restaurante
            Image(
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            // Texto del negocio
            Text(
                text = text,

                // Cambiamos el Stilo de la letra y color
                fontFamily = FontFamily.SansSerif,
                color = purple40,
                modifier = Modifier.padding(8.dp)

            )
        }
    }
}

// Preview del Codigo

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(onNavigateToSecondActivity = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessItem() {
    BusinessItem("Negocio de Ejemplo")
}
