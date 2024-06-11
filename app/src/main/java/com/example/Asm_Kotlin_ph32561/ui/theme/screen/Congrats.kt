package com.example.Asm_Kotlin_ph32561.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun Congrats(navController: NavController? = null) {
    getLayout(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun getLayout(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SUCCESS!",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            ),
            textAlign = TextAlign.Center,
            color = Color(0xFF303030),
            fontFamily = FontFamily(Font(R.font.merriweather_regular))
        )


        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.sucsess), // Replace with your actual image resource
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(268.dp)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your order will be delivered soon.\nThank you for choosing our app!",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp,
                color = Color(0xFF606060),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular))
            ),
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* TODO: Handle track your orders click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),


            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Track your orders",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.W600, // Trọng lượng font 600 tương ứng với SemiBold
                    fontSize = 18.sp, // Kích thước font 18sp
                    lineHeight = 24.55.sp, // Độ cao dòng 24.55px
                    color = Color.White, // Màu văn bản trắng
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)) // Sử dụng font Nunito Sans
                ),
                textAlign = TextAlign.Center // Căn giữa văn bản
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {

                navController?.navigate(Screen.MyBottombar.route)

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "BACK TO HOME",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.W600, // Trọng lượng font 600 tương ứng với SemiBold
                fontSize = 18.sp, // Kích thước font 18sp
                lineHeight = 24.55.sp, // Độ cao dòng 24.55px
                color = (Color(0xFF303030)), // Màu văn bản trắng
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)) // Sử dụng font Nunito Sans
            ),
            textAlign = TextAlign.Center
            )
        }
    }
}
