plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    defaultConfig {
        applicationId = "com.samples.hiltdemosession"

        compileSdk = AndroidSdk.compileSdkVersion
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
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
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Kotlin
    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.ktxCore)

    //UI
    implementation(Libraries.appCompat)
    implementation(Libraries.materialComponents)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.fragment)
    implementation(Libraries.legacySupport)

    //Logging: Timber
    implementation(Libraries.timber)

    //Hilt
    implementation(Libraries.hilt)
    kapt(Libraries.hiltKapt)

    //Coil
    implementation(Libraries.coil)

    //Lifecycle
    implementation(Libraries.viewModelKtx)
    implementation(Libraries.lifecycleRuntime)

    //Navigation
    implementation(Libraries.navigationUiKtx)
    implementation(Libraries.navigationFragmentKtx)

    //Coroutine
    implementation(Libraries.coroutinesCore)

    //Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.gson)
    implementation(Libraries.loggingInterceptor)

    //Hilt
    implementation(Libraries.hilt)
    kapt(Libraries.hiltKapt)

    //Glide
    implementation(Libraries.glide)
    implementation(Libraries.glideOkHttp){
      exclude("glide-parent")
    }
    kapt(Libraries.glideKapt)

    //DropCap
    implementation(Libraries.dropCap)

    //Test
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.extJunit)
    testImplementation(TestLibraries.mockWebServer)
    testImplementation(TestLibraries.truth)

    //Android Test
    androidTestImplementation(TestLibraries.espresso)
}