package com.jetbrains.kmm.shared.data.local

import android.content.Context
import com.example.db.AppDataBase
import com.jetbrains.kmm.shared.utils.ContextArgs
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDataBase.Schema, context,"todo.db")
    }
}

actual fun getSqlDriver(contextArgs: ContextArgs?): SqlDriver {
    return AndroidSqliteDriver(AppDataBase.Schema, contextArgs?.mContext!!, "AppDatabase.db")
}