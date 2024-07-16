plugins {
    alias(libs.plugins.composeModule.plugin)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlinx.parcelize)
}

android {
    namespace = "ru.disspear574.utils"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.koin.core)
    implementation(libs.bundles.orbit.mvi)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}
