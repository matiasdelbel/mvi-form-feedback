plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.fabrik.design"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.material3)
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.material3)

    debugImplementation(libs.androidx.ui.tooling)
}