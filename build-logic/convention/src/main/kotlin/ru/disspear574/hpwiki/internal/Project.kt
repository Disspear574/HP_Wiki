package ru.disspear574.hpwiki.internal

import com.android.build.api.dsl.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the

internal val Project.libs
    get() = the<LibrariesForLibs>()

internal fun Project.libraryExtension(action: LibraryExtension.() -> Unit) = extensions.configure<LibraryExtension>(action)
