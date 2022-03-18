package com.jetbrains.kmm.androidApp.navigation

import com.jetbrains.androidApp.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String){
    object RemoteTodos: BottomNavItem("Remote", R.drawable.home,"home")
    object LocalTodos: BottomNavItem("Local",R.drawable.local,"local")
}