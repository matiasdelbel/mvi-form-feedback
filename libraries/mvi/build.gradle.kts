plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.fabrik.mvi"
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
}