package ru.disspear574.hpwiki

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.imageLoader
import coil.memory.MemoryCache
import coil.util.DebugLogger
import di.KoinInjector
import org.koin.android.ext.koin.androidContext

class MainApplication : Application(), ImageLoaderFactory {
    companion object {
        lateinit var instance: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        KoinInjector.koinApp.androidContext(this)
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache
                    .Builder(this)
                    .maxSizePercent(0.20)
                    .build()
            }
            .diskCache {
                DiskCache
                    .Builder()
                    .directory(this.filesDir.resolve("images"))
                    .maxSizeBytes(5 * 1024 * 1024)
                    .build()
            }
            .crossfade(true)
//            .logger(DebugLogger())
            .respectCacheHeaders(false)
            .build()
    }
}
