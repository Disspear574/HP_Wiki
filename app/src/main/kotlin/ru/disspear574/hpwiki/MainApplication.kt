package ru.disspear574.hpwiki

import android.app.Application
import di.KoinInjector
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    companion object {
        lateinit var instance: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        KoinInjector.koinApp.androidContext(this)
    }
}
