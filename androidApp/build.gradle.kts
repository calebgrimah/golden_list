plugins {
    id(androidApp)
    kotlin(androidPlugin)
}

android {
    namespace = "ng.thenorthstar.goldenlist.android"
    compileSdk = Versions.compile_sdk
    defaultConfig {
        applicationId = "ng.thenorthstar.goldenlist.android"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    with(Deps){
        implementation(napier)
        implementation(material)
    }
    with(Deps.Compose){
        implementation(ui)
        implementation(tooling)
        implementation(tooling_preview)
        implementation(foundation)
        implementation(material)
        implementation(activity)
        implementation(runtime)
        implementation(runtime_livedata)
        implementation(foundationLayout)
        implementation(materialIcons)
        implementation(compiler)
        implementation(Deps.Coroutines.android)
        implementation(lifecycleRuntime)
        implementation(appCompat)
        implementation(viewmodel)
        implementation(uiUtil)
        implementation(coil)
        implementation(coreKtx)
        implementation(multiplatformSettings)
        implementation(multiplatformSettingsCoroutines)
        implementation(Deps.Koin.android)
        implementation(Deps.Koin.koinCompose)
        implementation(accompanistSwipeToRefresh)
        implementation(accompanistWebview)
    }

}