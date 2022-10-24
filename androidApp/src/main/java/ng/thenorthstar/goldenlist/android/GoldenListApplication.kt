package ng.thenorthstar.goldenlist.android

import android.app.Application
import ng.thenorthstar.goldenlist.android.di.appModule
import ng.thenorthstar.goldenlist.di.initKoin
import org.koin.android.ext.koin.androidContext

class GoldenListApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidContext(this@GoldenListApplication)
            modules(appModule)
        }
    }
}