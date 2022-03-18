package com.jetbrains.kmm.shared.shared_presentation.viewModel

import com.jetbrains.kmm.shared.di.KodeinInjector
import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.use_case.delete_todo.DeleteTodoUseCase
import com.jetbrains.kmm.shared.domain.use_case.getAllTodo.GetAllTodosUseCase
import com.jetbrains.kmm.shared.helper.Closable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.kodein.di.instance

class LocalTodosViewModel{
    //get use cases
    private val getAllTodosUseCase by KodeinInjector.instance<GetAllTodosUseCase>()
    private val deleteTodosUseCase by KodeinInjector.instance<DeleteTodoUseCase>()

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private val _todos = MutableStateFlow<List<Todo>>(mutableListOf())
    val todos: StateFlow<List<Todo>>
        get() = _todos

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getAllTodos()
    }

    //helper method for ios app to observe todos
    fun collectTodos(provideTodos: (List<Todo>) -> Unit) {
        //collect data here
        _todos.onEach {
            provideTodos.invoke(it)
        }.launchIn(coroutineScope)
    }

    fun deleteTodo(todoId: Long){
        coroutineScope.launch {
            kotlin.runCatching {
                deleteTodosUseCase(todoId)
            }.onSuccess {
                _eventFlow.emit(UIEvent.ShowSnackbar(
                    "todo deleted successfully"
                ))
            }.onFailure {
                _eventFlow.emit(UIEvent.ShowSnackbar(
                    "todo delete failed"
                ))
            }
        }
    }
    private fun getAllTodos(){
        coroutineScope.launch {
            kotlin.runCatching {
                getAllTodosUseCase()
            }.onSuccess {
                it.collect {
                    _todos.emit(it)
                }
            }.onFailure {
                _eventFlow.emit(UIEvent.ShowSnackbar(
                    "something went wrong"
                ))
            }
        }
    }
}