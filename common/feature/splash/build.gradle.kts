plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.presentation.splash"
}

dependencies {
    implementation(projects.common.domain)

    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.bundles.orbit.mvi)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(projects.common.core.coreUtils)
    implementation(projects.common.core.composeUi.components)
}
