package com.fabrik.form.review

import com.fabrik.mvi.SideEffectHandler
import kotlinx.coroutines.delay

class ReviewSideEffectHandler: SideEffectHandler<ReviewUiState<String>, ReviewIntent, ReviewSideEffect> {

    override suspend fun handle(state: ReviewUiState<String>, effect: ReviewSideEffect, onNewIntent: (ReviewIntent) -> Unit) {
        when (effect) {
            ReviewSideEffect.SubmitReview -> {
                delay(timeMillis = 2000)
                onNewIntent(ReviewIntent.ReviewSubmitted)
            }
        }
    }
}