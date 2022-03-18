package com.jetbrains.kmm.shared.data.local

import com.jetbrains.kmm.shared.utils.ContextArgs
import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

expect fun getSqlDriver(contextArgs: ContextArgs? = null): SqlDriver

object DatabaseCreator {
    fun getDataBase(contextArgs: ContextArgs?): TodoDataBase? {
        val sqlDriver  = getSqlDriver(contextArgs)
        if (sqlDriver != null) {
            return TodoDataBase(sqlDriver)
        } else {
            return null
        }
    }
}