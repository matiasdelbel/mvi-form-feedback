package com.fabrik.form.review

import com.fabrik.mvi.Reducer

class ReviewReducer(private val reviewValidator: ReviewValidator) : Reducer<ReviewUiState<String>, ReviewIntent, ReviewSideEffect> {

    override fun reduce(state: ReviewUiState<String>, intent: ReviewIntent, throwSideEffect: (ReviewSideEffect) -> Unit): ReviewUiState<String> = when (intent) {
        is ReviewIntent.RatingSelected -> {
            val newReview = state
                .review
                ?.copy(rating = intent.rating)
                ?: ReviewRatingUiState(rating = intent.rating)

            state.copy(
                errors = reviewValidator.validate(review = newReview),
                review = newReview
            )
        }

        is ReviewIntent.DescriptionChanged -> {
            val newReview = state
                .review
                ?.copy(description = intent.description)
                ?: ReviewRatingUiState(description = intent.description)

            state.copy(
                errors = reviewValidator.validate(review = newReview),
                review = newReview
            )
        }

        ReviewIntent.SubmitReview -> {
            val newReview = state
                .review
                ?.copy(synchronizing = true)
                ?: ReviewRatingUiState(synchronizing = true)

            state.copy(review = newReview)
        }

        ReviewIntent.ReviewSubmitted -> {
            val newReview = state
                .review
                ?.copy(synchronizing = false)
                ?: ReviewRatingUiState(synchronizing = false)

            state.copy(review = newReview)
        }
    }
}