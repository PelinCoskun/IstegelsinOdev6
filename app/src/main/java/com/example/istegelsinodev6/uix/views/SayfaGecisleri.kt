package com.example.istegelsinodev6.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "bottomBar") {
        composable("anasayfa") {
            Anasayfa(navController)
        }
        composable("bottomBar")
        {
            BottomBarSayfa(navController)
        }
    }
}