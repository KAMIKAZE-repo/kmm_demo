package com.jetbrains.kmm.shared.domain.use_case.GetRemoteTodosUseCase

import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.repository.TodoRepository

class FetchRemoteTodosUseCase(
    private val repository: TodoRepository
){
    suspend operator fun invoke(): List<Todo>{
        return repository.getRemoteTodos()
    }
}