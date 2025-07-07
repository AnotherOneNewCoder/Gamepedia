package com.zhogin.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
//import java.io.File
//
//private const val dbName = "AppDatabase.db"

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SqlDriverFactory actual constructor(context: Any?) {
    actual fun getSqlDriver(): SqlDriver {

//        val parentFolder = File(System.getProperty("java.io.tmpdir"))
//        //val parentFolder = File(System.getProperty("user.home") + "/Gamepedia")
//        if (!parentFolder.exists()) {
//            parentFolder.mkdirs()
//        }
//
//        val databasePath = File(System.getProperty("java.io.tmpdir"), dbName)
//        //val databasePath = File(parentFolder, dbName)

        return JdbcSqliteDriver(
            //url = "jdbc:sqlite:${databasePath.absolutePath}"
            url = "jdbc:sqlite:AppDatabase.db"
        )
    }
}