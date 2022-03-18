package com.jetbrains.kmm.shared.di

import com.jetbrains.kmm.shared.data.local.DatabaseCreator
import com.jetbrains.kmm.shared.data.local.LocalDataSource
import com.jetbrains.kmm.shared.data.local.LocalDataSourceImpl
import com.jetbrains.kmm.shared.data.remote.ApiService
import com.jetbrains.kmm.shared.data.remote.RemoteDataSource
import com.jetbrains.kmm.shared.data.remote.httpClient
import com.jetbrains.kmm.shared.data.remote.RemoteDataSourceImpl
import com.jetbrains.kmm.shared.data.repository.TodoRepositoryImpl
import com.jetbrains.kmm.shared.domain.repository.TodoRepository
import com.jetbrains.kmm.shared.domain.use_case.GetRemoteTodosUseCase.FetchRemoteTodosUseCase
import com.jetbrains.kmm.shared.domain.use_case.create_todo.CreateTodoUseCase
import com.jetbrains.kmm.shared.domain.use_case.delete_todo.DeleteTodoUseCase
import com.jetbrains.kmm.shared.domain.use_case.getAllTodo.GetAllTodosUseCase
import com.jetbrains.kmm.shared.domain.use_case.getTodoById.GetTodoByIdUseCase
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val KodeinInjector = DI{

    val httpclient = httpClient {
        install(Logging){
            level = LogLevel.ALL
            logger = object: Logger {
                override fun log(message: String) {
                    print(message)
                }
            }
        }
        install(JsonFeature){
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    //NETWORK API
    bind<ApiService>() with provider { ApiService() }

    //NETWORK DATA SOURCE
    bind<RemoteDataSource>() with provider { RemoteDataSourceImpl(instance(), httpclient) }

    //LocalDataSource
    bind<LocalDataSource>() with provider{ LocalDataSourceImpl(DatabaseCreator.getDataBase(InjectorCommon.mContextArgs)!!)}

    //REPOSITORIES
    bind<TodoRepository>() with provider { TodoRepositoryImpl(instance(), instance()) }

    //USE_CASES
    bind<CreateTodoUseCase>() with singleton { CreateTodoUseCase(instance()) }
    bind<DeleteTodoUseCase>() with singleton { DeleteTodoUseCase(instance()) }
    bind<GetTodoByIdUseCase>() with singleton { GetTodoByIdUseCase(instance()) }
    bind<GetAllTodosUseCase>() with singleton { GetAllTodosUseCase(instance()) }
    bind<FetchRemoteTodosUseCase>() with singleton { FetchRemoteTodosUseCase(instance()) }
}