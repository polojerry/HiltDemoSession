plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(project(BuildModules.domainModule))
    implementation(project(BuildModules.networkModule))

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
    implementation(Libraries.liveDataKtx)
    implementation(Libraries.viewModelKtx)

    //Navigation
    implementation(Libraries.navigationUiKtx)
    implementation(Libraries.navigationFragmentKtx)

    //Glide
    implementation(Libraries.glide)
    implementation("com.github.bumptech.glide:okhttp3-integration:4.4.0"){
      exclude("glide-parent")
    }
    kapt(Libraries.glideKapt)

    //Test
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.extJunit)

    //Android Test
    androidTestImplementation(TestLibraries.espresso)
}