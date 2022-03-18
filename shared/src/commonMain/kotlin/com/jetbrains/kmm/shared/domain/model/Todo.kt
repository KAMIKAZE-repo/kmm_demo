package com.jetbrains.kmm.shared.domain.model

data class Todo(
    val todoId: Long,
    val title: String,
    val completed: Boolean
)