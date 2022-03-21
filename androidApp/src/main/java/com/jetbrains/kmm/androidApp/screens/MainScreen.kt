package com.jetbrains.kmm.androidApp.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmm.androidApp.navigation.CustomBottomNavigation
import com.jetbrains.kmm.androidApp.navigation.NavigationGraph

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { CustomBottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }
}
