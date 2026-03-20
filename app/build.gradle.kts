plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.kotlinimc"
    compileSdk {
        version = release(36)
    }

defaultConfig {
    applicationId = "com.kotlinimc"
    minSdk = 24
    targetSdk = 36

    val versionCodeProp = project.findProperty("VERSION_CODE")?.toString()
    val versionNameProp = project.findProperty("VERSION_NAME")?.toString()

    versionCode = versionCodeProp?.toInt() ?: 1
    versionName = versionNameProp ?: "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
