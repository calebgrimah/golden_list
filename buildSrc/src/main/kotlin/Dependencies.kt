import kotlin.coroutines.coroutineContext

const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val androidLib = "com.android.library"
const val serializationPlugin = "org.jetbrains.kotlin.plugin.serialization"
const val multiplatform = "multiplatform"
const val appNamespace = "ng.thenorthstar.ypsmobile"
const val composePlugin = "org.jetbrains.compose"//for desktop version of the application
const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:1.5.3"
const val sqlDelightPlugin = "com.squareup.sqldelight"


object Versions {
    const val min_sdk = 23
    const val target_sdk = 33
    const val compile_sdk = 33

    const val kotlin = "1.7.20"
    const val kotlin_gradle_plugin = "1.7.20"
    const val android_gradle_plugin = "7.4.0"
    const val compose_compiler_version = "1.3.2"
    const val compose_version = "1.2.1"
    const val activity_compose = "1.6.0"
    const val accompanist_version = "0.25.1"

    const val coroutines = "1.6.4"
    const val junit = "4.13.2"
    const val junit5 = "1.5.10"
    const val material = "1.6.1"
    const val napier = "2.6.1"
    const val serialization = "1.4.0"
    const val frameworkName = "shared"
    const val kotlinxDateTime = "0.3.1"
    const val kmpNativeCoroutines = "0.13.1"
    const val koin = "3.2.2"
    const val ktorVersion = "2.1.2"
    const val lifecycle = "2.5.1"
    const val sqlDelight = "1.5.3"
    const val lifecycleVersion = "2.3.1"
    const val appCompatVersion = "1.3.0"
    const val coreKtx = "1.6.0"
    const val accompanistVersion = "0.13.0"
    const val klockVersion = "2.2.0"
    const val coilVersion = "2.2.2"
    const val multiplatformSettings = "1.0.0-RC"


}

object Deps {
    const val android_gradle_plugin =
        "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val junit = "junit:junit:${Versions.junit}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val napier = "io.github.aakira:napier:${Versions.napier}"

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose_version}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.compose_version}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$${Versions.lifecycleVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
        const val tooling_preview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose_version}"
        const val material = "androidx.compose.material:material:${Versions.compose_version}"
        const val materialIcons =
            "androidx.compose.material:material-icons-extended:${Versions.compose_version}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.compose_version}"
        const val compiler =
            "androidx.compose.compiler:compiler:${Versions.compose_compiler_version}"
        const val runtime_livedata =
            "androidx.compose.runtime:runtime-livedata:${Versions.compose_version}"
        const val foundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.compose_version}"
        const val activity = "androidx.activity:activity-compose:${Versions.activity_compose}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val coil = "io.coil-kt:coil:${Versions.coilVersion}"
        const val multiplatformSettings = "com.russhwolf:multiplatform-settings:${Versions.multiplatformSettings}"
        const val multiplatformSettingsCoroutines = "com.russhwolf:multiplatform-settings-coroutines:${Versions.multiplatformSettings}"
        const val accompanistSwipeToRefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist_version}"
        const val accompanistWebview =  "com.google.accompanist:accompanist-webview:${Versions.accompanist_version}"

    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val kSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    }

    object JetBrains {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    }

    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
        const val okhttp = "io.ktor:ktor-client-okhttp:${Versions.ktorVersion}"
        const val darwin = "io.ktor:ktor-client-darwin:${Versions.ktorVersion}"
        const val contentNegotiation =
            "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion}"
        const val ktxJsonSerialization =
            "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion}"
        const val logging = "io.ktor:ktor-client-logging:${Versions.ktorVersion}"
    }

    object SQLDelight {
        const val sqldelightRuntime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
        const val sqlDelightCoroutine = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
        const val sqlDelightAndroid = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
        const val sqlDelightIos = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
    }
}

