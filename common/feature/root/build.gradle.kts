plugins {
    alias(libs.plugins.composeModule.plugin)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.disspear574.presentation.root"
}

dependencies {
    implementation(projects.common.feature.splash)
    implementation(projects.common.feature.main.books)
    implementation(projects.common.feature.main.characters)

    implementation(libs.kotlinx.serialization.json)
    implementation(projects.common.core.coreUtils)

    implementation(libs.compose.navigation)
    implementation(libs.material.motion)

    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    implementation(libs.bundles.orbit.mvi)

    implementation(projects.common.core.composeUi.components)
    implementation(projects.common.core.composeUi.theme)
}
