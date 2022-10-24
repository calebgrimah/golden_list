package ng.thenorthstar.goldenlist.di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.dsl.module

actual fun settingsModule() = module {
    single<Settings>{
        SharedPreferencesSettings(get())
    }
}
