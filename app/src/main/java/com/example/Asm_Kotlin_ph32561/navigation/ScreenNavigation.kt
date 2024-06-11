package com.example.Asm_Kotlin_ph32561.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.Cart
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.CheckOutSrceen
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.Congrats
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.HomeSrceen
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.LoginScreen
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.ProductDetailScreen
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.SignSrceen
import com.example.Asm_Kotlin_ph32561.ui.theme.screen.Boarding

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Boarding.route,
    ) {
        composable(Screen.Boarding.route) { Boarding(navController) }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.SignSrceen.route) {

            SignSrceen(navController)
        }
        composable(Screen.MyBottombar.route) { MyBottombar(navController) }
        composable(Screen.HomeSrceen.route) { HomeSrceen(navController) }
        composable(
            "${Screen.ProductDetailScreen.route}/{productID}",
            arguments = listOf(navArgument("productID") { type = NavType.StringType })
        ) {
            ProductDetailScreen(
                productId = it.arguments?.getString("productID").orEmpty(),
                navController = navController
            )
        }
    composable (Screen.Cart.route) { Cart(navController) }
    composable(Screen.CheckOutSrceen.route) { CheckOutSrceen(navController) }
    composable(Screen.Congrats.route) { Congrats(navController) }
}
}