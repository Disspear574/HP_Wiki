package di

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.util.DebugLogger
import org.koin.dsl.module

val coilModule =
    module {
        single<ImageLoader> {
            ImageLoader(get())
        }
    }

fun ImageLoader(context: Context): ImageLoader =
    ImageLoader
        .Builder(context)
        .memoryCache {
            MemoryCache
                .Builder(context)
                .maxSizePercent(0.20)
                .build()
        }.diskCache {
            DiskCache
                .Builder()
                .directory(context.filesDir.resolve("images"))
                .maxSizeBytes(5 * 1024 * 1024)
                .build()
        }.crossfade(true)
        .logger(DebugLogger())
        .respectCacheHeaders(false)
        .build()
