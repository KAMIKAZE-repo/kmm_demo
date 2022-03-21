package com.jetbrains.kmm.androidApp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmm.androidApp.navigation.CustomBottomNavigation
import com.jetbrains.kmm.androidApp.navigation.NavigationGraph

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { CustomBottomNavigation(navController = navController) }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {

            NavigationGraph(navController = navController)
        }
    }
}
