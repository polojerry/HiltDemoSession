object Versions {
    //Version codes for all the libraries

    //Kotlin
    const val kotlin = "1.5.30"
    const val coreKtx = "1.6.0"

    //Ui
    const val legacy = "1.0.0"
    const val appCompat = "1.3.1"
    const val constraintLayout = "2.1.0"
    const val material = "1.4.0"
    const val fragment = "1.3.1"

    //AndroidX
    const val navigation = "2.3.5"
    const val lifecycle = "2.4.0-alpha01"

    //Coroutines
    const val coroutines = "1.3.9"

    //Hilt
    const val hilt = "2.38.1"

    //Timber
    const val timber = "5.0.1"

    //Firebase
    const val firebaseBom = "28.4.0"

    //Room
    const val room = "2.3.0"

    //Coil
    const val coil = "1.3.2"

    //Retrofit && OkHttp
    const val retrofit = "2.9.0"
    const val loggingInterceptor = "4.9.0"

    //Glide
    const val glide =  "4.11.0"
    const val glideOkHttp = "4.4.0"

    //DropCap
    const val dropCap = "1.1.0"

    //Version codes for all the test libraries
    const val junit4 = "4.13.1"
    const val testRunner = "1.3.1-alpha03"
    const val espresso = "3.4.0-alpha03"
    const val extJUnit = "1.1.2"
    const val coroutinesTest = "1.4.2"
    const val truth = "1.1.3"
    const val testCore = "1.0.0"
    const val mockWebServer = "4.9.0"
    const val roboelectric = "4.5-beta-1"

    // Gradle Plugins
    const val gradleBuild = "7.0.2"
    const val googlePlayServices = "4.3.10"
    const val firebaseCrashlyticsBuild = "2.3.0"
}

object BuildPlugins {
    //All the build plugins are added here
    const val androidLibrary = "com.android.library"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val navigationSafeArgsKtx = "androidx.navigation.safeargs.kotlin"
    const val kapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val parcelize = "kotlin-parcelize"
    const val playServices = "com.google.gms.google-services"
    const val crashlytics = "com.google.firebase.crashlytics"
}

object Libraries {
    //Any Library is added here
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.coreKtx}"

    //UI
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    //Navigation Component
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"

    //ViewModel, LiveData
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val kaptLifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    //Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseFirestoreKtx = "com.google.firebase:firebase-firestore-ktx"

    //Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    //Coil
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    //Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideOkHttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glideOkHttp}"

    //DropCap
    const val dropCap  = "com.novoda:drop-cap:${Versions.dropCap}"
}

object TestLibraries {
    //any test library is added here
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val core = "androidx.test:core:${Versions.testCore}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val navigation = "androidx.navigation:navigation-testing:${Versions.navigation}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val room = "androidx.room:room-testing:${Versions.room}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
}


object AndroidSdk {
    const val minSdkVersion = 21
    const val buildToolVersion = "30.0.3"
    const val compileSdkVersion = 30
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildModules {
    const val domainModule = ":domain"
}
