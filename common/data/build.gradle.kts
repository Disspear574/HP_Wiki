plugins {
    alias(libs.plugins.composeModule.plugin)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.disspear574.data"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(projects.common.domain)
//    implementation(projects.common.core.network)
//    implementation(projects.common.core.database)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.serialization.json)
}
