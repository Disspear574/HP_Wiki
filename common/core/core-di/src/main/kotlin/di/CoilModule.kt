package di

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.imageLoader
import coil.memory.MemoryCache
import coil.util.DebugLogger
import org.koin.dsl.module

val coilModule =
    module {
        single<ImageLoader> {
            customImageLoader(get())
        }
    }

fun customImageLoader(context: Context): ImageLoader = context.imageLoader
