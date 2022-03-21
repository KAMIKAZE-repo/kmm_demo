package com.jetbrains.kmm.androidApp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetbrains.kmm.androidApp.common.TodoList
import com.jetbrains.kmm.androidApp.navigation.NavigationGraph
import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.shared_presentation.viewModel.LocalTodosViewModel
import com.jetbrains.kmm.shared.shared_presentation.viewModel.UIEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LocalTodosScreen(viewModel: LocalTodosViewModel){
    //val todos: List<Todo> = viewModel.todos.collectAsState().value
    val todos = remember {
         mutableStateOf<List<Todo>>( mutableListOf<Todo>())
    }
    viewModel.collectTodos { newTodos -> todos.value = newTodos }
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            TodoList(todos = todos.value, icon = Icons.Default.Close, contentDescription = "delete todo"){
                viewModel.deleteTodo(it.todoId)
            }
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