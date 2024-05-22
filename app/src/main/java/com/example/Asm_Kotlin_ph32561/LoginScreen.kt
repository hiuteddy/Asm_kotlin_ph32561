@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
package com.example.Asm_Kotlin_ph32561

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
<<<<<<< HEAD
=======
import androidx.compose.material3.SnackbarHostState
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
<<<<<<< HEAD
import com.example.myapplication.R

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                LoginScreenContent()
            }
        }
    }
}

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
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
fun LoginScreenContent() {
=======
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun LoginScreen(navController: NavController) {
    loginScreenPreview(navController)
}

@Preview(showBackground = true)
@Composable
private fun loginScreenPreview(navController: NavController? = null) {
    getLayout(navController)
}

@Composable
private fun getLayout(navController: NavController? = null) {


>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
<<<<<<< HEAD
    )

    {
=======
    ) {
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
<<<<<<< HEAD
                        modifier = Modifier.padding(30.dp)

=======
            modifier = Modifier.padding(30.dp)
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
        ) {
            Box(
                modifier = Modifier
                    .width(162.dp)
                    .height(2.dp)
                    .background(color = Color(0xFFBDBDBD))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.group),
                contentDescription = "Logo",
                modifier = Modifier.size(65.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .width(162.dp)
                    .height(2.dp)
                    .background(color = Color(0xFFBDBDBD))
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Hello !",
            fontSize = 30.sp,
            color = Color(0xFFBDBDBD),
            modifier = Modifier.padding(start = 30.dp),
<<<<<<< HEAD
=======
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)

            )
        Text(
            text = "WELCOME BACK",
            fontSize = 24.sp,
            color = Color(0xFF303030),
            fontWeight = FontWeight.Bold,
<<<<<<< HEAD
            modifier = Modifier.padding(top = 10.dp, bottom = 40.dp, start = 30.dp)


        )

        Column (
            modifier = Modifier
                .fillMaxWidth() // Đảm bảo chiều rộng của Column lấp đầy toàn bộ chiều rộng của cha
                .height(500.dp)
                .padding(end = 45.dp) // Đảm bảo không có khoảng cách ngang
                .background(color = Color.White)
                .shadow(0.5.dp, RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp)) // Thêm shadow với độ mờ 8dp
        ){
            UnderlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Email", fontSize = 15.sp, color = Color(0xFF909090)) },
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, top = 35.dp),

                )
=======
            modifier = Modifier.padding(top = 10.dp, bottom = 40.dp, start = 30.dp),
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),

            )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(end = 45.dp)
                .background(color = Color.White)
                .shadow(0.5.dp, RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp))
        ) {
            UnderlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text(
                    text = "Email",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090)
                ) },
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, top = 35.dp)
            )
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
            Spacer(modifier = Modifier.height(40.dp))

            UnderlinedTextField(
                value = password,
                onValueChange = { password = it },
<<<<<<< HEAD
                label = { Text("Password", fontSize = 15.sp, color = Color(0xFF909090)) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image: Painter = if (passwordVisible) painterResource(id = R.drawable.aye) else painterResource(id = R.drawable.aye) // Replace R.drawable.aye with the correct drawable resource
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(painter = image, contentDescription = "Toggle password visibility")
                    }
                },
                modifier = Modifier.fillMaxWidth()
                   .padding(start = 30.dp)

=======
                label = { Text("Password",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090)
                ) },                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image: Painter = if (passwordVisible) painterResource(id = R.drawable.eye_slash_icon) else painterResource(id = R.drawable.eye_icon)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = image, contentDescription = "Toggle password visibility",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp)
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Forgot Password",
                fontSize = 18.sp,
                fontWeight = FontWeight.W600,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
<<<<<<< HEAD
=======
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),

>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
            )
            Button(
                onClick = {
                    if (userName.isNotBlank() && password.isNotBlank()) {
                        Toast.makeText(context, "Login successful", Toast.LENGTH_LONG).show()
<<<<<<< HEAD
=======
                        navController?.navigate(Screen.MyBottombar.route)

>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
                    } else {
                        Toast.makeText(
                            context,
                            "Please enter username and password",
                            Toast.LENGTH_LONG
<<<<<<< HEAD
                        )
                            .show()
=======
                        ).show()
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .width(400.dp)
                    .height(50.dp)
                    .padding(start = 30.dp)
            ) {
<<<<<<< HEAD
                Text(text = "Log in")
=======
                Text(
                    text = "Log in",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 24.5.sp,
                    color = Color(0xFFFFFFFF)
                )


>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
            }

            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
<<<<<<< HEAD
                onClick = { /* TODO: Navigate to Sign Up screen */ },
=======
                onClick = {
                    navController?.navigate(Screen.SignSrceen.route)
                },
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SIGN UP",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 24.55.sp,
                    textAlign = TextAlign.Center,
<<<<<<< HEAD
                    color = Color(0xFF303030)

                )
            }
        }

=======
                    color = Color(0xFF303030),
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),

                    )
            }
        }
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
    }
}

@Composable
fun UnderlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        label?.invoke()
        TextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = visualTransformation,
            trailingIcon = trailingIcon,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Gray,
                cursorColor = Color.Black,
                containerColor = Color.Transparent
<<<<<<< HEAD

=======
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
            ),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.Black)
        )
    }
}
<<<<<<< HEAD

=======
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
