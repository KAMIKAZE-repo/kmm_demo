package com.jetbrains.kmm.androidApp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetbrains.kmm.androidApp.common.TodoList
import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.shared_presentation.viewModel.RemoteTodoViewModel
import com.jetbrains.kmm.shared.shared_presentation.viewModel.UIEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RemoteTodoScreen(viewModel: RemoteTodoViewModel){
    //val todos: List<Todo> = viewModel.todos.collectAsState().value
    val todos = remember {
        mutableStateOf<List<Todo>>( mutableListOf())
    }
    viewModel.collectTodos {
        newTodos -> todos.value = newTodos

    }
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        TodoList(todos = todos.value, icon = Icons.Default.Add, contentDescription = "Save todo"){
            viewModel.createTodo(it)
        }
        //Show snackBar if error occurred
        LaunchedEffect(key1 = true) {
            viewModel.eventFlow.collectLatest { event ->
                when(event) {
                    is UIEvent.ShowSnackbar -> {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = event.message
                        )
                    }
                }
            }
        }
    }
}