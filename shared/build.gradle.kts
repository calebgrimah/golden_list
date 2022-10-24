plugins {
    kotlin(multiplatform)
    id(androidLib)
    id(serializationPlugin) version "1.7.20"
    id(sqlDelightPlugin)
    id("com.rickclephas.kmp.nativecoroutines")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Coroutines.core)
                implementation(Deps.Coroutines.kSerialization)
                with(Deps.Koin) {
                    api(core)
                    api(test)
                }
                with(Deps.Ktor) {
                    implementation(core)
                    implementation(contentNegotiation)
                    implementation(ktxJsonSerialization)
                    implementation(logging)
                }
                implementation(Deps.napier)
                implementation(Deps.Compose.multiplatformSettings)
                implementation(Deps.Compose.multiplatformSettingsCoroutines)
                implementation(Deps.SQLDelight.sqldelightRuntime)
                implementation(Deps.SQLDelight.sqlDelightCoroutine)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.Ktor.okhttp)
                implementation(Deps.SQLDelight.sqlDelightAndroid)
                api(Deps.Koin.android)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Deps.Ktor.darwin)
                implementation(Deps.SQLDelight.sqlDelightIos)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "ng.thenorthstar.goldenlist"
    compileSdk = Versions.compile_sdk
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
    }
}


sqldelight {
    database("goldenlistDb") {
        packageName = "ng.thenorthstar.goldenlist"
        schemaOutputDirectory = file("src/commonMain/sqldelight/ng/thenorthstar/goldenlist/db")
    }
}