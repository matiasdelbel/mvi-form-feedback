package com.fabrik.form.review

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ReviewModule {

    @Provides
    fun provideReviewReducer() = ReviewReducer(reviewValidator = ReviewValidator())

    @Provides
    fun provideSideEffectHandler() = ReviewSideEffectHandler()
}
