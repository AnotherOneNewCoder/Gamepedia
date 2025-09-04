package com.zhogin.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

//actual class SqlDriverFactory actual constructor(context: Any?) {
//    actual suspend fun getSqlDriver(): SqlDriver {
//        return NativeSqliteDriver(
//            AppDatabase.Schema.synchronous(),
//            name = "AppDatabase.db",
//            onConfiguration = {
//                it.copy(
//                    extendedConfig = DatabaseConfiguration.Extended(
//                        foreignKeyConstraints = true
//                    )
//                )
//            }
//        )
//    }
//}


//
actual class SqlDriverFactory actual constructor(context: Any?) {
    actual fun getSqlDriver(): SqlDriver {
        return NativeSqliteDriver(
            AppDatabase.Schema,
            name = "AppDatabase.db"
        )
    }
}

