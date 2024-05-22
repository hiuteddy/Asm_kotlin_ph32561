package com.example.Asm_Kotlin_ph32561

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class ProductDetailScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                ProductDetailScreen(onBackClicked = { finish() })
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun ProductDetailScreen(onBackClicked: () -> Unit) {
    var quantity by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBackClicked) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Product Details",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Minimal Stand",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "$50",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Decrease")
            }
            Text(
                text = "$quantity",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            IconButton(onClick = { quantity++ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
            }
        }


        Row(verticalAlignment = Alignment.CenterVertically) {
            for (i in 1..5) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    tint = if (i <= 4) Color.Yellow else Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "4.5 (50 reviews)",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Text(
            text = "Minimal Stand is made of natural wood...",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )



        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Add to cart action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(Icons.Filled.ShoppingCart, contentDescription = "Add to cart")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add to cart")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: Save action */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(Icons.Filled.Share, contentDescription = "Save")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Save")
        }
    }
}
