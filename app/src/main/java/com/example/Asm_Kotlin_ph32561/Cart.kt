package com.example.Asm_Kotlin_ph32561

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Preview(showBackground = true)
@Composable
fun Cart(navController: NavController? = null) {
    getLayout(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun getLayout(navController: NavController? = null) {
    val items = listOf(
        Product("Minimal Stand", "$25.00", R.drawable.cart_item_1),
        Product("Coffee Chair", "$20.00", R.drawable.cart_item_2),

        Product("Coffee Chair", "$20.00", R.drawable.cart_item_3),


        )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),

                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            navController?.popBackStack()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow),
                                contentDescription = "Back",
                                modifier = Modifier.size(16.dp),
                                tint = Color(0xFF242424) // Màu rgba(36, 36, 36, 1) tương ứng

                            )
                        }
                        Spacer(modifier = Modifier.width(105.dp)) // Khoảng cách 30dp

                        Text(
                            text = "My Cart",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold, // Merriweather với weight là 700
                            fontFamily = FontFamily(Font(R.font.merriweather_regular)),
                            color = Color.Black, // Màu rgba tương ứng
                            textAlign = TextAlign.Center, // Align Center
                            lineHeight = 20.11.sp // Line height 20.11px
                        )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent, // Set to transparent
                    titleContentColor = Color.White,
                ),
            )


        },

        )
    { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {


            LazyColumn(
                modifier = Modifier.weight(1f).padding(16.dp) // Let the LazyColumn take all available vertical space

             // Thay 56dp bằng chiều cao của top app bar
            ) {
                items.forEachIndexed { index, item ->
                    item {
                        FavoriteItem(item)
                        if (index < items.size - 1) {
                            Divider(
                                color = Color.Gray,
                                thickness = 1.dp,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                }
            }

            PromoCodeScreen(navController = navController)

            }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteItem(product: Product) {
    var quantity by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = FontFamily.SansSerif,
                color = Color(
                    0xFF999999
                )
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = product.price,
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily.SansSerif,
                color = Color(
                    0xFF242424
                )
            )

            Spacer(modifier = Modifier.height(23.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { if (quantity > 1) quantity-- },
                    modifier = Modifier
                        .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(10.dp))
                        .size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = "Decrease quantity",
                        modifier = Modifier.size(14.dp),
                        tint = Color.Black
                    )
                }
                Text(
                    text = quantity.toString().padStart(2, '0'),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF242424),
                    modifier = Modifier.padding(horizontal = 15.dp)
                )


                IconButton(
                    onClick = { quantity++ },
                    modifier = Modifier
                        .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(10.dp))
                        .size(30.dp)
                )
                {
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "Increase quantity",
                        modifier = Modifier.size(14.dp),
                        tint = Color.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { /* TODO: Handle remove click */ },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.remove),
                    contentDescription = "Remove",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Black
                )
            }
        }
    }
}


@Composable
fun PromoCodeScreen(navController: NavController?) {
    var promoCode by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PromoCodeInput(
            promoCode = promoCode,
            onPromoCodeChange = { promoCode = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TotalAmount(total = 95.00)
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController?.navigate(Screen.CheckOutSrceen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .height(60.dp),
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(
                text = "Check out",
                fontSize = 20.sp, // Kích thước 20px
                fontWeight = FontWeight.SemiBold, // Weight 600 tương ứng với FontWeight.SemiBold
                lineHeight = 27.28.sp, // Line height 27.28px
                textAlign = TextAlign.Center, // Align Center
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)) // Font Nunito Sans
            )
        }
    }
}
@Composable
fun PromoCodeInput(promoCode: TextFieldValue, onPromoCodeChange: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(8.dp))
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = promoCode,
            onValueChange = onPromoCodeChange,
            singleLine = true,
            textStyle = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            if (promoCode.text.isEmpty()) {
                Text(
                    text = "Enter your promo code",
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                )
            }
            it()
        }
        IconButton(
            onClick = { /* Handle icon click */ },
            modifier = Modifier
                .size(45.dp)
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Submit",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun TotalAmount(total: Double) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Total: ",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 27.28.sp,
            color = Color(0xFF808080),
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),

            )
        Text(
            text = "$$total",
            fontSize = 20.sp, // Font size 20px
            fontWeight = FontWeight.W700, // Weight 700
            lineHeight = 27.28.sp, // Line height 27.28px
            color = Color(0xFF303030), // Color #303030

        )
    }

}


