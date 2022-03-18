package com.jetbrains.kmm.shared.data.local

import com.example.db.AppDataBase
import com.jetbrains.kmm.shared.utils.ContextArgs
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver{
        return NativeSqliteDriver(AppDataBase.Schema, "todo.db")
    }
}

actual fun getSqlDriver(contextArgs: ContextArgs?): SqlDriver {
    return NativeSqliteDriver(AppDataBase.Schema, "AppDatabase.db")
}