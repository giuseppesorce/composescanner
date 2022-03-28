object Sdk {
    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 32
    const val COMPILE_SDK_VERSION = 32
    const val BUILD_TOOL_VERSION = "32.0.0"
}

object Vers {

    const val GRADLE = "7.0.4"
    const val KOTLIN = "1.6.10"

    const val HILT = "2.38.1"
    const val DAGGER_VERSION = "2.38.1"
    const val COREKTX = "1.7.0"
    const val APPCOMPACT = "1.4.1"
    const val CONSTRAINTLAYOUT = "2.1.2"

    //COMPOSE
    const val COMPOSE = "1.1.0"
    const val COMPOSEACTIVITY = "1.3.1"
    const val COMPOSECONSTRAINLAYOUT = "1.0.0"
    const val COMPOSEPERMISSIONS = "0.22.1-rc"
    const val COMPOSEVIEWMODEL = "2.4.0"

    //Testing
    const val JUNIT = "4.13.1"
    const val ANDROIDX_TEST_EXT = "1.1.2"
    const val ANDROIDX_TEST = "1.3.0"
    const val ESPRESSO_CORE = "3.3.0"

    //Mocking
    const val MOCKK = "1.10.2"
    const val CORE_TESTING = "2.1.0"
    const val COROUTINES_TESTING = "1.4.0"
    const val BUILDTOOLS = "4.1.1"

    //timber
    const val TIMBER = "4.7.1"

    //CAMERA X
    const val CAMERAX = "1.0.2"
    const val CAMERA2= "1.1.0-beta02"
    const val CAMERAX_VIEW = "1.1.0-beta02"
    const val IFINTERFACE = "1.3.3"

    //Room
    const val ROOM = "2.4.2"

    //Coroutines
    const val COROUTINES_VERS = "1.4.0"
    //Lifecycle
    const val LIFECYCLE_VERSION = "2.3.1"
    const val LIFECYCLE_EXT_VERSION = "2.2.0"

    // Network
    const val OKHTTP = "4.8.1"
    const val RETROFIT = "2.9.0"
    const val LOGGING_INTERCEPTOR = "3.4.2"
    const val SAVESTATE_VERS = "1.0.0"
    const val SECURITY_CRYPTO = "1.1.0-alpha03"

    // Material component
    const val MATERIAL_VERS = "1.4.0"

    const val FRAGMENT_KTXT_VERS = "2.3.3"
    const val LIFECYCLE_VIEWMODEL = "1.0.0-alpha02"
    const val HILT_COMPILER = "1.0.0-alpha03"
    const val SERIALITATION = "1.2.0"
    const val K_SERIALITATION_CONVERTER = "0.8.0"
    const val KOTLIN_SERIALITATION = "1.0.0"

    //Coil
    const val COIL = "1.1.1"
    const val LOTTIE = "4.2.1"

    //activity extension
    const val ACTIVITY_KTX = "1.2.0"

    //Leak Canary
    const val LEAKCANARY = "2.8.1"
    const val SIGNATURE_PAD = "1.3.1"
    const val LOCATION_SERVICE = "18.0.0"
    const val MAPS = "17.0.0"
    const val LIFECYCLE_SERVICE = "2.3.0"
    const val MLKIT_SCANNER_VERS = "16.1.4"
    const val LOGGING_PRETTY_PRINT = "1.1.0"

    //Fragment
    const val FRAGMENT_X = "1.3.1"

    //PhotoView
    const val PHOTOVIEW_VERS: String = "2.0.0"

    //PhotoView
    const val KRONOS_VERSION: String = "0.0.1-alpha11"

    //Firebase
    //fireabse
    const val FIREBASE_PLUGIN_VER = "2.8.1"
    const val FIREBASE_VERS = "29.0.3"
    // UI
    const val RECYCLERVIEW = "1.2.0"
}

object Deps {
    const val KOTLIN_STLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.KOTLIN}"
    const val coreKtx = "androidx.core:core-ktx:${Vers.COREKTX}"
    const val appCompact = "androidx.appcompat:appcompat:${Vers.APPCOMPACT}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Vers.CONSTRAINTLAYOUT}"
    const val NAVIGATION_FRAG_KTX =
        "androidx.navigation:navigation-fragment-ktx:${Vers.FRAGMENT_KTXT_VERS}"
    const val navigation_ui_ktx =
        "androidx.navigation:navigation-ui-ktx:${Vers.FRAGMENT_KTXT_VERS}"
    const val buildTools = "com.android.tools.build:gradle:${Vers.BUILDTOOLS}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Vers.KOTLIN}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Vers.ACTIVITY_KTX}"
    const val TIMBER_DEP = "com.jakewharton.timber:timber:${Vers.TIMBER}"
    const val CANARY_DEP = "com.squareup.leakcanary:leakcanary-android:${Vers.LEAKCANARY}"
    const val SIGNATURE_PAD = "com.github.gcacace:signature-pad:${Vers.SIGNATURE_PAD}"
    // crypto
    const val CRYPTO_DEP = "androidx.security:security-crypto:${Vers.SECURITY_CRYPTO}"
    //Fragment
    const val FRAGMENT_JAVA = "androidx.fragment:fragment:${Vers.FRAGMENT_X}"
    const val FRAGMENT_KOTLIN = "androidx.fragment:fragment-ktx:${Vers.FRAGMENT_X}"
    object UIDesign {
        const val material_design =
            "com.google.android.material:material:${Vers.MATERIAL_VERS}"
        const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Vers.RECYCLERVIEW}"
        const val COIL = "io.coil-kt:coil:${Vers.COIL}"
        const val COIL_BASE = "io.coil-kt:coil-base:${Vers.COIL}"
        const val LOTTIE = "com.airbnb.android:lottie:${Vers.LOTTIE}"
    }

    object ViewModel {
        const val VIEMODEL_DEP =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Vers.LIFECYCLE_EXT_VERSION}"
        const val VIEMODEL_JAVA8_DEP =
            "androidx.lifecycle:lifecycle-common-java8:${Vers.LIFECYCLE_VERSION}"
        const val viewmodel_reactivestreams_dep =
            "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Vers.LIFECYCLE_VERSION}"
        const val viewmodel_livedata_dep =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Vers.LIFECYCLE_VERSION}"
        const val viewmodel_savedstate_dep =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Vers.LIFECYCLE_VERSION}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Vers.LIFECYCLE_VERSION}"
    }
}

object Compose {

    const val composeUI = "androidx.compose.ui:ui:${Vers.COMPOSE}"
    const val composeUIMaterial ="androidx.compose.material:material:${Vers.COMPOSE}"
    const val composeToolingPreview ="androidx.compose.ui:ui-tooling-preview:${Vers.COMPOSE}"
    const val composeTooling ="androidx.compose.ui:ui-tooling:${Vers.COMPOSE}"
    const val composeActivity ="androidx.activity:activity-compose:${Vers.COMPOSEACTIVITY}"
    const val composeConstraintLayout ="androidx.constraintlayout:constraintlayout-compose:${Vers.COMPOSECONSTRAINLAYOUT}"
    const val composeMaterialIcons ="androidx.compose.material:material-icons-extended:${Vers.COMPOSE}"
    const val composeViewModel ="androidx.lifecycle:lifecycle-viewmodel-compose:${Vers.COMPOSEVIEWMODEL}"
    object Permissions {
        const val permissions ="com.google.accompanist:accompanist-permissions:${Vers.COMPOSEPERMISSIONS}"
    }

}

object Camera {
    //CAMERA X
    const val CAMERAX_CORE = "androidx.camera:camera-core:${Vers.CAMERAX}"
    const val CAMERA2= "androidx.camera:camera-camera2:${Vers.CAMERA2}"
    const val CAMERAX_LYFECYCLE = "androidx.camera:camera-lifecycle:${Vers.CAMERAX}"
    const val CAMERAX_VIEW = "androidx.camera:camera-view:${Vers.CAMERAX_VIEW}"
    const val CAMERAX_EXTENSION = "androidx.camera:camera-camera2:${Vers.CAMERAX}"
    const val EXITFINNTERFACE = "androidx.exifinterface:exifinterface:${Vers.IFINTERFACE}"
}


object Kotlin {
    const val SERIALITATION_CORE =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Vers.SERIALITATION}"
    const val SERIALIZATION_JSON =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Vers.SERIALITATION}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vers.COROUTINES_VERS}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Vers.COROUTINES_VERS}"
    const val SERIALITATPION_JVM =
        "org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:${Vers.SERIALITATION}"
}


object DI {
    //DAGGER
    const val DAGGER_DEP = "com.google.dagger:dagger:${Vers.DAGGER_VERSION}"
    const val DAGGER_ANNOTATION = "com.google.dagger:dagger-compiler:${Vers.DAGGER_VERSION}"
    //Hilt
    const val HILT_DEP = "com.google.dagger:hilt-android:${Vers.HILT}"
    const val HILT_KAPT = "com.google.dagger:hilt-android-compiler:${Vers.HILT}"
    const val HILT_ANDROID_KAPT_TEST =
        "com.google.dagger:hilt-android-compiler:${Vers.HILT}"
    const val HILT_KAPT_TEST = "com.google.dagger:hilt-android-compiler:${Vers.HILT}"
    const val HILT_VIEWMODEL =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Vers.LIFECYCLE_VIEWMODEL}"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Vers.HILT_COMPILER}"
}

object AndroidTestingLib {
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Vers.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Vers.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:${Vers.ANDROIDX_TEST_EXT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Vers.ESPRESSO_CORE}"
    const val RETROFIT_MOCK = "com.squareup.retrofit2:retrofit-mock:${Vers.RETROFIT}"
}

object TestingLib {
    const val JUNIT = "junit:junit:${Vers.JUNIT}"
}

object MockingLib {
    const val MOCKK_DEP = "io.mockk:mockk:1.10.2"
    const val CORETESTING = "androidx.arch.core:core-testing:2.1.0"
    const val MOCK_COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.0"
}

