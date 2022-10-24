package ng.thenorthstar.goldenlist.db

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import ng.thenorthstar.goldenlist.goldenlistDb
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

internal actual fun Scope.createDriver(databaseName: String): SqlDriver =
    AndroidSqliteDriver(goldenlistDb.Schema,androidContext(), databaseName)