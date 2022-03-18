package com.jetbrains.kmm.androidApp.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jetbrains.kmm.shared.domain.model.Todo

@Composable
fun TodoList(todos: List<Todo>,  icon: ImageVector, contentDescription: String, function: (Todo) -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Todo List")
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(Modifier.fillMaxSize()){
            items(todos){ todo ->
                TodoCard(todo = todo, icon = icon, contentDescription){
                    function(it)
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}