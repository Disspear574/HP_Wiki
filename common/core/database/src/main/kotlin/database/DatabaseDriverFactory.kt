package database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.disspear574.database.HPDatabase

class DatabaseDriverFactory(
    private val context: Context,
) {
    fun createDriver(): SqlDriver = AndroidSqliteDriver(HPDatabase.Schema, context, "hp.dp")
}
