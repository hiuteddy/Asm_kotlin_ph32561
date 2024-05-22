package com.example.Asm_Kotlin_ph32561


<<<<<<< HEAD
=======
import android.annotation.SuppressLint
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
<<<<<<< HEAD
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
=======
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
<<<<<<< HEAD
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class SignSrceen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.example.Asm_Kotlin_ph32561.MyApplicationTheme {
                SignUpScreenContent()
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
    fun SignUpScreenContent() {
        val context = LocalContext.current
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        var confirmPasswordVisible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(30.dp)

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

            Text(
                text = "WELCOME BACK",
                fontSize = 24.sp,
                color = Color(0xFF303030),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp, bottom = 40.dp, start = 30.dp)


            )
            Column(
                modifier = Modifier
                    .fillMaxWidth() // Đảm bảo chiều rộng của Column lấp đầy toàn bộ chiều rộng của cha
                    .height(600.dp)
                    .padding(end = 45.dp) // Đảm bảo không có khoảng cách ngang
                    .background(color = Color.White)
                    .shadow(
                        0.5.dp,
                        RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp)
                    ) // Thêm shadow với độ mờ 8dp
            ) {
                UnderlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text("Name", fontSize = 15.sp, color = Color(0xFF909090)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, top = 35.dp),
                )

                Spacer(modifier = Modifier.height(20.dp))

                UnderlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email", fontSize = 15.sp, color = Color(0xFF909090)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                UnderlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", fontSize = 15.sp, color = Color(0xFF909090)) },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image =
                            if (passwordVisible) Icons.Filled.Add else Icons.Filled.ArrowBack
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = image,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                UnderlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = {
                        Text(
                            "Confirm Password",
                            fontSize = 15.sp,
                            color = Color(0xFF909090)
                        )
                    },
                    visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image =
                            if (confirmPasswordVisible) Icons.Filled.Add else Icons.Filled.ArrowBack
                        IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                            Icon(
                                imageVector = image,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, bottom = 50.dp)
                )
                Button(
                    onClick = {
                        if (userName.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
                            if (password == confirmPassword) {
                                Toast.makeText(context, "Sign up successful", Toast.LENGTH_LONG)
                                    .show()
                            } else {
                                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG)
                                    .show()
                            }
                        } else {
                            Toast.makeText(context, "Please fill all fields", Toast.LENGTH_LONG)
                                .show()
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
                    Text(text = "SIGN UP")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                    ,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically                ) {
                    Text(
                        text = "Already have account?",
                        fontSize = 14.sp,
                        color = Color(0xFF909090),
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    TextButton(
                        onClick = { /* TODO: Navigate to Sign In screen */ },
                        contentPadding = PaddingValues(0.dp) // Loại bỏ padding của TextButton

                    ) {
                        Text(
                            text = "SIGN IN",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF303030),
                            fontFamily = FontFamily.SansSerif,
                        )
                    }

                }


            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
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

    }
}
=======
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R


@Composable
fun SignSrceen(navController: NavController) {
    signSrceenPreview(navController)
}

@Preview(showBackground = true)
@Composable
private fun signSrceenPreview(navController: NavController? = null) {
    getLayout(navController)
}

@Composable
private fun getLayout(navController: NavController? = null) {
    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(30.dp)

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

        Text(
            text = "WELCOME ",
            fontSize = 24.sp,
            color = Color(0xFF303030),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp, bottom = 40.dp, start = 30.dp),
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),


            )
        Column(
            modifier = Modifier
                .fillMaxWidth() // Đảm bảo chiều rộng của Column lấp đầy toàn bộ chiều rộng của cha
                .height(600.dp)
                .padding(end = 45.dp) // Đảm bảo không có khoảng cách ngang
                .background(color = Color.White)
                .shadow(
                    0.5.dp,
                    RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp)
                ) // Thêm shadow với độ mờ 8dp
        ) {
            UnderlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Name",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090)
                ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = 35.dp),
            )

            Spacer(modifier = Modifier.height(20.dp))

            UnderlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090)
                ) },                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            UnderlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090)
                ) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image: Painter =
                        if (passwordVisible) painterResource(id = R.drawable.eye_slash_icon) else painterResource(
                            id = R.drawable.eye_icon
                        ) // Replace R.drawable.aye with the correct drawable resource
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = image, contentDescription = "Toggle password visibility",
                            modifier = Modifier.size(20.dp) // Adjust the size as needed
                        )

                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            UnderlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = {
                    Text(
                        "Confirm Password",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        lineHeight = 19.1.sp,
                        color = Color(0xFF909090)
                    )

                },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image: Painter =
                        if (passwordVisible) painterResource(id = R.drawable.eye_slash_icon) else painterResource(
                            id = R.drawable.eye_icon
                        ) // Replace R.drawable.aye with the correct drawable resource

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = image, contentDescription = "Toggle password visibility",
                            modifier = Modifier.size(20.dp) // Adjust the size as needed
                        )

                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, bottom = 50.dp)
            )
            Button(
                onClick = {
                    if (userName.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
                        if (password == confirmPassword) {
                            navController?.navigate(Screen.LoginScreen.route)
                            Toast.makeText(context, "Sign up successful", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG)
                                .show()
                        }
                    } else {
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_LONG)
                            .show()
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
                Text(text = "SIGN UP",
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                lineHeight = 24.5.sp,
                color = Color(0xFFFFFFFF)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have account?",
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color(0xFF909090),
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                TextButton(
                    onClick = {
                        navController?.navigate(Screen.LoginScreen.route)
                    },
                    contentPadding = PaddingValues(0.dp) // Loại bỏ padding của TextButton

                ) {
                    Text(
                        text = "SIGN IN",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF303030),
                        lineHeight = 19.1.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    )
                }

            }


        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
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

}
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
