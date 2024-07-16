plugins {
    alias(libs.plugins.composeModule.plugin)
    alias(libs.plugins.sqldelight)
}

android {
    namespace = "ru.disspear574.database"
}

dependencies {
    implementation(libs.sqldelight.runtime)
    implementation(libs.sqldelight.android.driver)
    implementation(projects.common.data)
    implementation(projects.common.core.network)
    implementation(libs.coil)
    implementation(libs.koin.core)
}
sqldelight {
    databases {
        create("HPDatabase") {
            packageName.set("ru.disspear574.database")
        }
    }
}
