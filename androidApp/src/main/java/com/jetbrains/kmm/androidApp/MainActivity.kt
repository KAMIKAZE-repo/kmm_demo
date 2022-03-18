package com.jetbrains.kmm.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmm.androidApp.navigation.CustomBottomNavigation
import com.jetbrains.kmm.androidApp.navigation.NavigationGraph
import com.jetbrains.kmm.androidApp.screens.RemoteTodoScreen
import com.jetbrains.kmm.androidApp.theme.KmmSampleAppTheme
import com.jetbrains.kmm.shared.data.local.DatabaseDriverFactory
import com.jetbrains.kmm.shared.data.local.TodoDataBase
import com.jetbrains.kmm.shared.data.remote.ApiService
import com.jetbrains.kmm.shared.data.repository.TodoRepositoryImpl
import com.jetbrains.kmm.shared.domain.repository.TodoRepository
import com.jetbrains.kmm.shared.shared_presentation.viewModel.RemoteTodoViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    @Composable
    fun App(){
        KmmSampleAppTheme {
            MainScreenView()
        }
    }
}

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { CustomBottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }
}
