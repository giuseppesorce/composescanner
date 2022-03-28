plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = AppCoordinates.APP_ID
        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION
        versionCode = AppCoordinates.APP_VERSION_CODE
        versionName = AppCoordinates.APP_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

   implementation(project(":scanner"))

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
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Vers.COMPOSE}")
    debugImplementation(Compose.composeTooling)
}