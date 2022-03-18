package com.jetbrains.kmm.shared.data.local

import com.example.db.AppDataBase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import comexampledb.TodoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TodoDataBase(sqlDriver: SqlDriver) {
    private val dispatcher = Dispatchers.Default
    private val dataBase = AppDataBase(sqlDriver)
    private val todoQueries = dataBase.appDataBaseQueries

    suspend fun createTodo(todoEntity: TodoEntity) {
        withContext(dispatcher){
            with(todoEntity){
                todoQueries.insertTodo(id, title, completed)
            }
        }
    }

    suspend fun deleteTodoById(todoId: Long) {
        withContext(dispatcher){
            todoQueries.deleteTodo(todoId)
        }
    }

    suspend fun getTodoById(todoId: Long): TodoEntity? {
        return withContext(dispatcher){
            todoQueries.getTodoById(todoId).executeAsOneOrNull()
        }
    }

    fun getAllTodos(): Flow<List<TodoEntity>> {
        return todoQueries.getAllTodos().asFlow().mapToList()
    }
}