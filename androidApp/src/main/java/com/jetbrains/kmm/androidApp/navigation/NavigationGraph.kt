package com.jetbrains.kmm.androidApp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetbrains.kmm.androidApp.screens.LocalTodosScreen
import com.jetbrains.kmm.androidApp.screens.RemoteTodoScreen
import com.jetbrains.kmm.shared.shared_presentation.viewModel.LocalTodosViewModel
import com.jetbrains.kmm.shared.shared_presentation.viewModel.RemoteTodoViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.RemoteTodos.screenRoute) {
        composable(BottomNavItem.RemoteTodos.screenRoute) {
            RemoteTodoScreen(RemoteTodoViewModel())
        }
        composable(BottomNavItem.LocalTodos.screenRoute) {
            LocalTodosScreen(LocalTodosViewModel())
        }
    }
}