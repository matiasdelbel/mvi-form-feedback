package com.fabrik.form.review

sealed interface ReviewSideEffect {

    object SubmitReview: ReviewSideEffect
}