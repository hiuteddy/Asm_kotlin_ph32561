package com.example.Asm_Kotlin_ph32561

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreenContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(
        TabItem("Popular", R.drawable.sofa),
        TabItem("Chair", R.drawable.p6),
        TabItem("Table", R.drawable.bed),
        TabItem("Armchair", R.drawable.star),
        TabItem("Bed", R.drawable.chair),
        TabItem("Bed", R.drawable.chair),


        )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* TODO: Handle search click */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "Search",
                                modifier = Modifier.size(20.31.dp),
                                tint = Color(0xFF808080)
                            )
                        }
                        Column {
                            Text(
                                text = "Make home ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.Serif, // Replace with FontFamily.Gelasio if available
                                color = Color(0xFF909090),
                                textAlign = TextAlign.Center,
                                lineHeight = 25.sp
                            )
                            Text(
                                text = "BEAUTIFUL",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif, // Replace with FontFamily.Gelasio if available
                                color = Color(0xFF242424),
                                textAlign = TextAlign.Center,
                                lineHeight = 25.sp
                            )
                        }

                        IconButton(
                            onClick = { /* TODO: Handle cart click */ },
                            modifier = Modifier.padding(end = 15.dp) // Padding end to 15.dp
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.shop),
                                contentDescription = "Cart",
                                modifier = Modifier.size(20.31.dp),
                                tint = Color(0xFF808080)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent, // Set to transparent
                    titleContentColor = Color.White,

                    ),

            )

        },
        bottomBar = { BottomNavigationBar() }


    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            CategoryRow(tabs = tabs, selectedTab = selectedTab) { index ->
                selectedTab = index
            }
            ProductGrid()
        }
    }
}

@Composable
fun CategoryRow(tabs: List<TabItem>, selectedTab: Int, onTabSelected: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tabs.size) { index ->
            val tab = tabs[index]
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 23.dp, top = 25.dp)
                    .clickable { onTabSelected(index) }
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (selectedTab == index) Color.DarkGray else Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = tab.icon),
                        contentDescription = tab.title,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = tab.title,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp)
                )
            }
        }
    }
}

@Composable
fun ProductGrid() {
    val products = listOf(
        Product("Black Simple Lamp", "$12.00", R.drawable.item1),
        Product("Minimal Stand", "$25.00", R.drawable.item2),
        Product("Coffee Chair", "$20.00", R.drawable.item2),
        Product("Simple Desk", "$50.00", R.drawable.item1)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductItem(products[index])
        }
    }
}
@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .padding(7.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)),
                contentScale = ContentScale.Crop
            )
            // Thêm ảnh nhỏ ở góc dưới bên phải của ảnh lớn
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 15.dp, bottom = 25.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.item_icon),
                    contentDescription = "Small Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
        // Thêm các Text dưới Box
        Text(
            text = product.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF606060),
            lineHeight = 19.1.sp,
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp) // Điều chỉnh padding theo ý muốn
        )
        Text(
            text = product.price,
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF303030),
            lineHeight = 19.1.sp
        )
    }


}
@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White.copy(alpha = 1.0f) // Sử dụng màu trắng bóng
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Trang chủ") },
            selected = false,
            onClick = { /* TODO: Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Lịch sử") },
            selected = false,
            onClick = { /* TODO: Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Giỏ hàng") },
            selected = true, // Item đang được chọn
            onClick = { /* TODO: Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Hồ sơ") },
            selected = false,
            onClick = { /* TODO: Handle navigation */ }
        )
    }
}




data class Product(val name: String, val price: String, val imageResId: Int)
data class TabItem(val title: String, val icon: Int)
