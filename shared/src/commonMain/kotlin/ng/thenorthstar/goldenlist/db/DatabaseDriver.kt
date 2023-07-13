package ng.thenorthstar.goldenlist.db

import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.scope.Scope

internal expect fun Scope.createDriver(databaseName: String): SqlDriver


//A new commment for the pr
//A second update
