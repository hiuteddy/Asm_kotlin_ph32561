package com.example.Asm_Kotlin_ph32561.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.Asm_Kotlin_ph32561.navigation.Screen
import com.example.myapplication.R

@Preview(showBackground = true)
@Composable
fun CheckOutSrceen(navController: NavController? = null) {
    getLayout(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun getLayout(navController: NavController? = null) {
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
                            text = "Check Out",
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
        Column(modifier = Modifier.padding(innerPadding))
        {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AddressSection()
                PaymentSection()
                DeliverySection()
                Spacer(modifier = Modifier.height(10.dp))

                OrderSummarySection(orderAmount = 95.00, deliveryAmount = 5.00)
                Spacer(modifier = Modifier.height(10.dp))

                SubmitOrderButton(navController = navController)
            }
        }
    }
}

@Composable
fun AddressSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        SectionHeader(title = "Shipping Address")
        SectionCard {
            Text(
                "Bruno Fernandes",
                style = typography.titleMedium.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF303030)
                )
            )
            Spacer(
                modifier = Modifier.height(1.dp)

            )
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Giảm kích thước của Box
                    .height(1.dp)
                    .background(color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "25 rue Robert Latouche, Nice, 06200, Côte D'azur,\n France",
                style = typography.bodyMedium.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 25.sp,
                    color = Color(0xFF808080)
                )
            )
        }
    }
}

@Composable
fun PaymentSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        SectionHeader(title = "Payment")
        SectionCard {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {


                    Image(
                        painter = painterResource(id = R.drawable.card),
                        contentDescription = "Mastercard",
                        modifier = Modifier
                            .width(64.dp) // Width 64px
                            .height(38.dp) // Height 38px
                            .background(Color.White, shape = RoundedCornerShape(8.dp)),
                    )


                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    "**** **** **** 3947",
                    style = typography.bodyLarge.copy(
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        letterSpacing = (-0.15).sp,
                        color = Color(0xFF242424)
                    )
                )
            }
        }
    }
}

@Composable
fun DeliverySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        SectionHeader(title = "Delivery method")
        SectionCard {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pay),
                    contentDescription = "DHL",
                    Modifier
                        .width(88.dp)
                        .height(20.dp)

                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    "Fast (2-3days)",
                    style = typography.bodyLarge.copy(
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight.W700,
                        fontSize = 14.sp,
                        lineHeight = 19.1.sp,
                        color = Color(0xFF303030)
                    )
                )
            }
        }
    }
}

@Composable
fun OrderSummarySection(orderAmount: Double, deliveryAmount: Double) {
    SectionCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Order:",
                style = typography.bodyLarge.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF808080)
                )
            )
            Text(
                text = "$ $orderAmount",
                style = typography.bodyLarge.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF242424),
                    textAlign = TextAlign.End
                )
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Delivery:",
                style = typography.bodyLarge.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF808080)
                )
            )
            Text(
                "$ ${deliveryAmount}", style = typography.bodyLarge.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF242424),
                    textAlign = TextAlign.End
                )
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Total:",
                style = typography.bodyLarge.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF808080)
                )

            )
            Text(
                "$ ${orderAmount + deliveryAmount}",
                style = typography.bodyLarge.copy(
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 24.55.sp,
                    color = Color(0xFF242424),
                    textAlign = TextAlign.End)
            )
        }

    }
}

@Composable
fun SubmitOrderButton(navController: NavController?) {
    Button(
        onClick = {
            navController?.navigate(Screen.Congrats.route)

        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
        ,
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
    ) {
        Text(
            text = "SUBMIT ORDER",
            color = Color.White, // Màu trắng #FFFFFF
            fontSize = 20.sp, // Kích thước 20px
            fontWeight = FontWeight.SemiBold, // Weight 600 tương ứng với FontWeight.SemiBold
            lineHeight = 27.28.sp, // Line height 27.28px
            textAlign = TextAlign.Center, // Align Center
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)) // Font Nunito Sans
        )

    }
}

@Composable
fun SectionCard(content: @Composable ColumnScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            content = content
        )
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title, style = typography.titleMedium.copy(
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                lineHeight = 24.55.sp,
                color = Color(0xFF909090)
            )
        )
        IconButton(onClick = { /* Handle edit action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "Edit",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

