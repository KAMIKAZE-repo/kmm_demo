package com.jetbrains.kmm.shared.shared_presentation.viewModel

import com.jetbrains.kmm.shared.di.KodeinInjector
import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.use_case.GetRemoteTodosUseCase.FetchRemoteTodosUseCase
import com.jetbrains.kmm.shared.domain.use_case.create_todo.CreateTodoUseCase
import com.jetbrains.kmm.shared.helper.Closable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.kodein.di.instance

class RemoteTodoViewModel {
    //Get use cases
    private val remoteTodosUseCase by KodeinInjector.instance<FetchRemoteTodosUseCase>()
    private val createTodoUseCase by KodeinInjector.instance<CreateTodoUseCase>()

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
    fun collectTodos(provideTodos: (List<Todo>) -> Unit){
        //collect data here
        _todos.onEach {
            provideTodos.invoke(it)
        }.launchIn(coroutineScope)
    }

    fun getAllTodos(){
        coroutineScope.launch {
            kotlin.runCatching {
                remoteTodosUseCase()
            }.onSuccess {
                _todos.emit(it)
                print("data loaded ${it}")
            }.onFailure {
                _eventFlow.emit(UIEvent.ShowSnackbar(
                    it.message.toString()
                ))
            }
        }
    }

    fun createTodo(todo: Todo){
        coroutineScope.launch {
            kotlin.runCatching {
                createTodoUseCase(todo)
            }.onSuccess {
                _eventFlow.emit(UIEvent.ShowSnackbar(
                    "todo saved successfully"
                ))
            }.onFailure {
                _eventFlow.emit(UIEvent.ShowSnackbar(
                    "saving todo failed"
                ))
            }
        }
    }
}