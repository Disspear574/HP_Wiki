package ru.disspear574.hpwiki.internal

import org.gradle.api.Project

internal val Project.kotlinPluginId
    get() =
        libs.plugins.kotlin.android
            .get()
            .pluginId

internal val Project.libraryPluginId
    get() =
        libs.plugins.android.library
            .get()
            .pluginId

internal val Project.composeCompilerPluginId
    get() =
        libs.plugins.compose.compiler
            .get()
            .pluginId
