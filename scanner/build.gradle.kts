plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Sdk.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.coreKtx)
    implementation(Deps.appCompact)
    //Compose dependencies
    implementation(Compose.composeUI)
    implementation(Compose.composeUIMaterial)
    implementation(Compose.composeToolingPreview)
    implementation(Compose.composeActivity)
    implementation(Compose.composeConstraintLayout)
    implementation(Compose.composeMaterialIcons)
    implementation(Compose.composeViewModel)
    // accompanist
    implementation(Compose.Permissions.permissions)
    //ViewModel
    implementation(Deps.ViewModel.lifecycle_runtime_ktx)
    // CameraX
    implementation(Camera.CAMERAX_CORE)
    implementation(Camera.CAMERAX_LYFECYCLE)
    implementation(Camera.CAMERAX_VIEW)
    implementation(Camera.CAMERAX_EXTENSION)
    implementation(Camera.CAMERA2)
    //MLKIT Scan
    implementation(GoogleService.MLKIT_SCAN)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Vers.COMPOSE}")
    debugImplementation(Compose.composeTooling)
}