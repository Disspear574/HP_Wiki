plugins {
    alias(libs.plugins.composeModule.plugin)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.disspear574.presentation.characters"
}
dependencies {
    implementation(projects.common.domain)

    implementation(libs.kotlinx.serialization.json)
    implementation(projects.common.core.coreUtils)

    implementation(libs.compose.navigation)

    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    implementation(libs.bundles.orbit.mvi)

    implementation(projects.common.core.composeUi.components)
}
