package com.jetbrains.kmm.androidApp.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jetbrains.kmm.shared.domain.model.Todo

@Composable
fun TodoCard(todo: Todo, icon: ImageVector, contentDescription: String, function: (Todo) -> Unit){
    Card (
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { },
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = todo.title)
                Text(text = if(todo.completed) "Completed" else "Pending", color = if(todo.completed) Color.Green else Color.Red)
            }
            IconButton(onClick = { function(todo) }) {
                Icon(imageVector = icon, contentDescription)
            }
        }
    }
}