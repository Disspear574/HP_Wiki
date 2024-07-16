plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.di"
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.coil)
    implementation(projects.common.data)
    implementation(projects.common.domain)
    implementation(projects.common.core.network)
    implementation(projects.common.core.database)
    implementation(projects.common.feature.splash)
    implementation(projects.common.feature.main.books)
    implementation(projects.common.feature.main.characters)
    implementation(projects.common.feature.root)
}
