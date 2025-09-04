package com.zhogin.core.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver


//actual class SqlDriverFactory actual constructor(context: Any?) {
//
//    private val context = context as Context
//
//    actual suspend fun getSqlDriver(): SqlDriver {
//        val schema = AppDatabase.Schema.synchronous()
//        return AndroidSqliteDriver(
//            schema = schema,
//            context = context,
//            name = "AppDatabase.db",
//            callback = object : AndroidSqliteDriver.Callback(schema) {
//                override fun onOpen(db: SupportSQLiteDatabase) {
//                    db.setForeignKeyConstraintsEnabled(true)
//                }
//            }
//        )
//    }
//}

//actual class SqlDriverFactory actual constructor(context: Any?) {
//
//    private val context = context as Context
//
//    actual fun getSqlDriver(): SqlDriver {
//        return AndroidSqliteDriver(
//            schema = AppDatabase.Schema,
//            context = context,
//            name = "AppDatabase.db"
//        )
//    }
//}

actual class SqlDriverFactory actual constructor(context: Any?) {

    private val context = context as Context
    actual fun getSqlDriver(): SqlDriver {
        val driver = AndroidSqliteDriver(
            schema = AppDatabase.Schema,
            context = context,
            name = "AppDatabase.db",
        )


        return driver
    }

}



