package com.example.Asm_Kotlin_ph32561

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Boarding.route,
    ) {
        composable(Screen.Boarding.route) { Boarding(navController) }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                navController
            )
        }
        composable(Screen.SignSrceen.route) {
            SignSrceen(
                navController
            )
        }
        composable(Screen.MyBottombar.route) { MyBottombar(navController) }
        composable(Screen.HomeSrceen.route) { HomeSrceen(navController) }
        composable(Screen.ProductDetailScreen.route) { ProductDetailScreen(navController) }
        composable(Screen.Cart.route) { Cart(navController) }
        composable(Screen.CheckOutSrceen.route) { CheckOutSrceen(navController) }


        composable(Screen.Congrats.route) { Congrats(navController) }



    }
}