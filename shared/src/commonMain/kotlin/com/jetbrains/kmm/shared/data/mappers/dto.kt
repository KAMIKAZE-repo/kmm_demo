package com.jetbrains.kmm.shared.data.mappers

import com.jetbrains.kmm.shared.data.remote.response.NetworkTodo
import com.jetbrains.kmm.shared.domain.model.Todo
import comexampledb.TodoEntity

fun TodoEntity?.toDomain(): Todo?{
    return if ( this != null)
         Todo(
            id,
            title,
            completed = completed == 1L
        )
    else
        null
}

fun List<TodoEntity>.toDomain(): List<Todo>{
    return this.map { it.toDomain()!! }
}

fun Todo.toDbModel(): TodoEntity{
    return TodoEntity(
        todoId,
        title,
        completed = if(completed) 1L else 0L
    )
}

fun NetworkTodo.toDomain(): Todo {
    return Todo(
        id.toLong(),
        title,
        completed
    )
}