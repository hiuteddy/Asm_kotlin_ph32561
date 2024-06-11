@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.Asm_Kotlin_ph32561.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.SnackbarHostState
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.Asm_Kotlin_ph32561.navigation.Screen
import com.example.Asm_Kotlin_ph32561.request.LoginRequest
import com.example.Asm_Kotlin_ph32561.viewmodel.ViewModelAuthenticate
import com.example.myapplication.R
import kotlinx.coroutines.launch

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
private fun getLayout(
    navController: NavController? = null, viewModelAuth: ViewModelAuthenticate = viewModel()
) {

    val login by viewModelAuth.login
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    fun Login() {
        val request = LoginRequest(email, password)
        viewModelAuth.loginViewModel(request)
    }

    LaunchedEffect(key1 = login) {
        if (login != null) {
            if (login?.status == 200) {
                navController?.navigate(Screen.MyBottombar.route)
            } else {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(login?.message ?: "Lỗi không xác định")
                }
            }
        }

    }



    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(30.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(122.dp)
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
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),

            )
        Text(
            text = "WELCOME BACK",
            fontSize = 24.sp,
            color = Color(0xFF303030),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp, bottom = 40.dp, start = 30.dp),
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),

            )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(437.dp)
                .padding(end = 45.dp)
                .background(color = Color.White)
                .shadow(0.5.dp, RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp))
        ) {
            UnderlinedTextField(value = email, onValueChange = { email = it }, label = {
                Text(
                    text = "Email",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090)
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 35.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))

            UnderlinedTextField(value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        "Password",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        lineHeight = 19.1.sp,
                        color = Color(0xFF909090)
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image: Painter =
                        if (passwordVisible) painterResource(id = R.drawable.eye_slash_icon) else painterResource(
                            id = R.drawable.eye_icon
                        )
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = image,
                            contentDescription = "Toggle password visibility",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Forgot Password",
                fontSize = 18.sp,
                fontWeight = FontWeight.W600,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
            Button(
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Không được để trống")
                        }
                    } else {
                        Login()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424), contentColor = Color.White
                ),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .width(400.dp)
                    .height(50.dp)
                    .padding(start = 30.dp, end = 15.dp)
            ) {
                Text(
                    text = "Log in",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 24.5.sp,
                    color = Color(0xFFFFFFFF)
                )


            }

            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                onClick = {
                    navController?.navigate(Screen.SignSrceen.route)
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SIGN UP",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 24.55.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF303030),
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),)
            }
        }
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
            ),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.Black)
        )
    }
}
