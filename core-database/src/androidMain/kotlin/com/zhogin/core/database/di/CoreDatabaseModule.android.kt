package com.zhogin.core.database.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import com.zhogin.core.database.AppDatabase
import com.zhogin.core.database.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getCoreDatabaseModule(): Module {
    return module {
//        single { SqlDriverFactory(get<Context>()).getSqlDriver() }
        single { SqlDriverFactory(get<Context>()).getSqlDriver() }
        single { AppDatabase.invoke(get<SqlDriver>()) }
    }
}