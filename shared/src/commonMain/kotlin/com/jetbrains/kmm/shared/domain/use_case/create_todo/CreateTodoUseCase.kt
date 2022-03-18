package com.jetbrains.kmm.shared.domain.use_case.create_todo

import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.repository.TodoRepository

class CreateTodoUseCase(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo){
        todoRepository.createTodo(todo)
    }
}