plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.presentation.root"
}

dependencies {
    implementation(projects.common.feature.splash)
    implementation(projects.common.feature.main.books)
    implementation(projects.common.feature.main.characters)
}