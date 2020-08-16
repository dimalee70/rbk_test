package kz.v.rbk_test

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        Timber.i("onCreate")
        super.onCreate()
        appContext = applicationContext
        setKoin()
        setupTimber()
    }

    private fun setKoin(){
        Timber.i("setKoin")
        startKoin {
//            fileProperties()
            androidContext(this@App)
//            modules(mainModule)
//            modules(networkModule)
        }
        appContext = applicationContext
    }
    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}