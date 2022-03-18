package com.jetbrains.kmm.shared.domain.use_case.getTodoById

import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.repository.TodoRepository

class GetTodoByIdUseCase(
    private val repository: TodoRepository
){
    suspend operator fun invoke(todoId: Long): Todo?{
        return repository.getTodoById(todoId)
    }
}