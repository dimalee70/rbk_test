import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 25
    const val compileSdk = 29
    const val targetSdk = 25
    val javaVersion = JavaVersion.VERSION_1_8
    const val buildTools = "25.0.0"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val androidx_appcompat = "1.1.0"
    const val androidx_navigation = "2.3.0-rc01"
    const val androidx_material = "1.1.0"
    const val android_core = "1.3.0"
    const val androidx_constraintLayout = "1.1.3"
    const val gradleandroid = "4.0.0"
    const val gradleversions = "0.21.0"
    const val kotlin = "1.3.72"

    //log
    const val timber = "4.7.1"

    //lifecycle
    const val lifecycle = "2.2.0"
    const val lifecycle_test = "2.1.0"

    //di
    const val koin_version = "2.1.5"
    const val koin_test = "2.0.1"

    // <editor-fold desc="testing">
    const val junit = "4.13"
    const val androidx_espresso = "3.1.0"
    const val androidx_testing = "1.1.1"

    const val activity_ktx = "1.2.0-alpha06"
    const val fragment_ktx = "1.3.0-alpha06"
}

object Deps {
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompat}"
    const val androidx_core = "androidx.core:core-ktx:${Versions.android_core}"
    const val save_args =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidx_navigation}"
    const val tools_kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val tools_gradleandroid = "com.android.tools.build:gradle:${Versions.gradleandroid}"
    const val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val tools_gradleversions =
        "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleversions}"

    // Constraint layout
    const val androidx_constraint =
        "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"

    // Koin
    const val androidx_koin = "org.koin:koin-android:${Versions.koin_version}"
    const val koin_scope = "org.koin:koin-androidx-scope:${Versions.koin_version}"
    const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
    const val koin_test = "org.koin:koin-test:${Versions.koin_test}"

    //Lifecycle
    const val lifecycle_process = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
    const val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_test = "androidx.arch.core:core-testing:${Versions.lifecycle_test}"

    // Material
    const val material = "com.google.android.material:material:${Versions.androidx_material}"

    // Navigation
    const val navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigation}"
    const val navigaition_ui =
        "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigation}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val testlib_junit = "junit:junit:${Versions.junit}"

    const val testandroidx_rules = "androidx.test:rules:${Versions.androidx_testing}"
    const val testandroidx_runner = "androidx.test:runner:${Versions.androidx_testing}"
    const val testandroidx_espressocore =
        "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_ktx}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"


}