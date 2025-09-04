package com.zhogin.core.database.di

import app.cash.sqldelight.db.SqlDriver
import com.zhogin.core.database.AppDatabase
import com.zhogin.core.database.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getCoreDatabaseModule(): Module {
    return module {
        //single { SqlDriverFactory() }
        single { SqlDriverFactory().getSqlDriver() }
        single { AppDatabase.invoke(get<SqlDriver>()) }
    }
}