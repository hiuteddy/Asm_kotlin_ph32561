package com.example.Asm_Kotlin_ph32561.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.Asm_Kotlin_ph32561.navigation.Screen
import com.example.Asm_Kotlin_ph32561.repository.CategoryResponse
import com.example.Asm_Kotlin_ph32561.repository.ProductResponse
import com.example.Asm_Kotlin_ph32561.viewmodel.ViewModelCategory
import com.example.Asm_Kotlin_ph32561.viewmodel.ViewModelProduct
import com.example.myapplication.R

@Preview(showBackground = true)
@Composable
fun HomeSrceen(navController: NavController? = null) {
    getLayout(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun getLayout(navController: NavController? = null) {
    val viewModelCategory: ViewModelCategory = viewModel()
    val categories by viewModelCategory.categories
    val viewModelProduct: ViewModelProduct = viewModel()
    val listProduct by viewModelProduct.listProduct

    var isSearchBarVisible by remember { mutableStateOf(false) }



    val selectedTab by remember { mutableStateOf(-1) }
    var searchText by remember { mutableStateOf("") }


    fun searchProducts() {
        viewModelProduct.searchProductViewModel(searchText)
    }


    LaunchedEffect(Unit) {
        viewModelCategory.categoryViewModel()
        viewModelProduct.listProductViewModel(categories.getOrNull(selectedTab)?.cateID)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp, bottom = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isSearchBarVisible) {
                            TextField(
                                value = searchText,
                                onValueChange = { searchText = it },
                                placeholder = { Text("Search") },
                                singleLine = true,
                                modifier = Modifier.weight(1f)
                            )
                        } else {
                            IconButton(onClick = { searchProducts(); isSearchBarVisible = true })
                            {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = "Search",
                                    modifier = Modifier.size(20.dp),
                                    tint = Color(0xFF808080)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "Make home ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                                color = Color(0xFF909090),
                                textAlign = TextAlign.Center,
                                lineHeight = 25.sp
                            )
                            Text(
                                text = "BEAUTIFUL",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                                color = Color(0xFF242424),
                                textAlign = TextAlign.Center,
                                lineHeight = 25.sp
                            )
                        }
                        IconButton(
                            onClick = {
                                navController?.navigate(Screen.Cart.route)
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
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
                    containerColor = Color.Transparent,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            CategoryRow(tabs = categories, selectedTab = selectedTab) { index ->
                viewModelProduct.listProductViewModel(categories.getOrNull(index)?.cateID)
            }
            ProductGrid(navController, listProduct)
        }
    }
}

@Composable
fun ProductGrid(navController: NavController? = null, products: List<ProductResponse>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            ProductItem(product, navController)
        }
    }
}

@Composable
fun CategoryRow(tabs: List<CategoryResponse>, selectedTab: Int, onTabSelected: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Add a special item for "All Products"
        item {
            val isSelected = selectedTab == -1 // Check if it's the "All Products" item
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 15.dp, top = 25.dp)
                    .clickable { onTabSelected(-1) } // Pass -1 for "All Products"
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) Color.DarkGray else Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sofa), // Change to appropriate icon
                        contentDescription = "All Products", // Change to appropriate description
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = "All Products",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = if (isSelected) Color.DarkGray else Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp)
                )
            }
        }
        // Display the rest of the categories
        items(tabs.size) { index ->
            val tab = tabs[index]
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 15.dp, top = 25.dp)
                    .clickable { onTabSelected(index) }
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (selectedTab == index) Color.DarkGray else Color.LightGray)
                ) {

                    AsyncImage(
                        model = tab.image,
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )

                }
                Text(
                    text = tab.cateName,
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = if (selectedTab == index) Color.DarkGray else Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp)
                )
            }
        }
    }
}

@Composable
fun ProductItem(product: ProductResponse, navController: NavController? = null) {
    Column(
        modifier = Modifier
            .padding(start = 3.dp)
            .clickable {
                navController?.navigate("${Screen.ProductDetailScreen.route}/${product.productID}")
            }
    ) {
        Box(
            modifier = Modifier
                .width(170.dp)
                .height(210.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 15.dp, bottom = 25.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.item_icon), // Change to appropriate small icon
                    contentDescription = "Small Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
        Text(
            text = product.productName,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            color = Color(0xFF606060),
            lineHeight = 19.1.sp,
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        )
        Text(
            text = "$${product.price}",
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            color = Color(0xFF303030),
            lineHeight = 19.1.sp
        )
    }
}




