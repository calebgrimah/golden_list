package ng.thenorthstar.goldenlist.db

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import ng.thenorthstar.goldenlist.goldenlistDb
import org.koin.core.scope.Scope


internal actual fun Scope.createDriver(databaseName : String): SqlDriver =
    NativeSqliteDriver(goldenlistDb.Schema, databaseName)