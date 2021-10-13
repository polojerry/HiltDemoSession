plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    defaultConfig {
        compileSdk = AndroidSdk.compileSdkVersion
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
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
}

dependencies {
    implementation(project(BuildModules.domainModule))

    //Kotlin
    implementation(Libraries.ktxCore)

    //Coroutine
    implementation(Libraries.coroutinesCore)

    //Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.gson)
    implementation(Libraries.loggingInterceptor)

    //Hilt
    implementation(Libraries.hilt)
    kapt(Libraries.hiltKapt)

    //Test
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.extJunit)
    testImplementation(TestLibraries.mockWebServer)
    testImplementation(TestLibraries.truth)


}