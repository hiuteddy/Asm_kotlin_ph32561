package com.example.Asm_Kotlin_ph32561

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
=======
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
<<<<<<< HEAD
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
=======
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.myapplication.R


@Preview(showBackground = true)
@Composable
fun ProductDetailScreen(navController: NavController? = null) {

    Box {
        Box(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 50.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = null,
                Modifier
                    .size(40.dp)
                    .clickable(onClick = {
                        navController?.popBackStack()
                    })
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    start = 40.dp,
                    top = 150.dp
                )
                .zIndex(1f)
        ) {
            Column(
                modifier = Modifier
                    .width(64.dp)
                    .height(192.dp)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(50.dp)
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 5.dp,
                            color = Color("#909090".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {}

                Column(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            Color("#B4916C".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 5.dp,
                            color = Color("#F0F0F0".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {}

                Column(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            Color("#E4CBAD".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 5.dp,
                            color = Color("#F0F0F0".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {}
            }
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.minimalstand),
                contentDescription = null,
                Modifier
                    .width(323.dp)
                    .height(455.dp)
                    .align(Alignment.End)
                    .clip(RoundedCornerShape(bottomStart = 50.dp))
            )

            Column(
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        top = 20.dp,
                        end = 20.dp,
                    )
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                        })
            ) {

                // tên sản phẩm
                Text(
                    text = "Minimal Stand",
                    fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                    fontWeight = FontWeight(500),
                    fontSize = 24.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    // giá
                    Text(
                        text = "$ 50",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(700),
                        fontSize = 30.sp,
                    )

                    // số lượng
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(113.dp)
                    ) {

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(30.dp)
                                .background(
                                    Color("#F0F0F0".toColorInt()),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Text(
                                text = "+",
                                color = Color("#242424".toColorInt()),
                                fontSize = 24.sp,
                            )
                        }

                        Text(
                            text = "1",
                            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                            fontWeight = FontWeight(600),
                            fontSize = 18.sp,
                            color = Color("#242424".toColorInt()),
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                        )

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(30.dp)
                                .background(
                                    Color("#F0F0F0".toColorInt()),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Text(
                                text = "-",
                                color = Color("#242424".toColorInt()),
                                fontSize = 24.sp,
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // đánh giá
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                            colorFilter = ColorFilter.tint(Color.Yellow) // Màu vàng
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "4.8",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(700),
                        fontSize = 18.sp,
                        color = Color("#303030".toColorInt())
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(
                        text = "(50 reviews)",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        color = Color("#808080".toColorInt())
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                // mô tả
                Text(
                    text = "Minimal Stand is made of by natural wood. " +
                            "The design that is very simple and minimal. " +
                            "This is truly one of the best furnitures in any family for now. " +
                            "With 3 different colors, you can easily select the best match for your home. ",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight(300),
                    fontSize = 14.sp,
                    color = Color("#606060".toColorInt()),
                )

            }
        }

        Box(
            modifier = Modifier
                .padding(
                    bottom = 20.dp,
                    start = 20.dp,
                    top = 750.dp,
                    end = 20.dp
                )
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()),
                            RoundedCornerShape(8.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.addtofavourite),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color("#242424".toColorInt())
                    ),
                    modifier = Modifier
                        .height(60.dp)
                        .width(250.dp)
                        .background(
                            Color("#242424".toColorInt()),
                            RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = "Add to cart",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 20.sp,
                    )
                }
            }

            // nút thêm vào yêu thích


        }

    }

    }

>>>>>>> feb2e70 (Hoàn thiện 8 màn hình)
