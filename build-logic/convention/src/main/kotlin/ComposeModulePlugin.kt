import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import ru.disspear574.hpwiki.internal.composeCompilerPluginId
import ru.disspear574.hpwiki.internal.debugImplementation
import ru.disspear574.hpwiki.internal.implementation
import ru.disspear574.hpwiki.internal.kotlinPluginId
import ru.disspear574.hpwiki.internal.libraryExtension
import ru.disspear574.hpwiki.internal.libraryPluginId
import ru.disspear574.hpwiki.internal.libs

class ComposeModulePlugin : Plugin<Project> {
    override fun apply(target: Project) =
        with(target) {
            apply(plugin = libraryPluginId)
            apply(plugin = kotlinPluginId)
            apply(plugin = composeCompilerPluginId)

            libraryExtension {
                compileSdk =
                    libs.versions.compileSDK
                        .get()
                        .toInt()

                defaultConfig {
                    minSdk =
                        libs.versions.minSDK
                            .get()
                            .toInt()
                    compileSdk =
                        libs.versions.compileSDK
                            .get()
                            .toInt()

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//                consumerProguardFiles("consumer-rules.pro")
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro",
                        )
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_21
                    targetCompatibility = JavaVersion.VERSION_21
                }
                buildFeatures {
                    compose = true
                }
            }
            dependencies {
                implementation(platform(libs.androidx.compose.bom))
                implementation(libs.androidx.ui.graphics)
                implementation(libs.androidx.material3)
                implementation(libs.androidx.ui.tooling.preview)
                debugImplementation(libs.androidx.ui.tool)
            }
        }
}
