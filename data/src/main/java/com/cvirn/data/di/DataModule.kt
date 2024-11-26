package com.cvirn.data.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.cvirn.data.repository.TaskRepositoryImpl
import org.koin.dsl.module
import sqldelight.db.Database

val dataModule =
    module {
        single<SqlDriver> {
            // Replace "YourDatabase" with your SQLDelight Database name
            AndroidSqliteDriver(
                schema = Database.Schema,
                context = get(), // Koin provides Android context
                name = "app_database.db",
            )
        }
        single { Database(get()) }
        single { TaskRepositoryImpl(get()) }
    }
