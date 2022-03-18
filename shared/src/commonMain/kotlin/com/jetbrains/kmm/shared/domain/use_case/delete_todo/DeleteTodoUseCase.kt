package com.jetbrains.kmm.shared.domain.use_case.delete_todo

import com.jetbrains.kmm.shared.domain.repository.TodoRepository
import kotlinx.serialization.descriptors.PrimitiveKind

class DeleteTodoUseCase(
    private val repository: TodoRepository
){
    suspend operator fun invoke(todoId: Long){
        repository.deleteTodoById(todoId)
    }
}