package com.fabrik.form.review

import com.fabrik.mvi.Reducer

class ReviewReducer(private val reviewValidator: ReviewValidator) : Reducer<ReviewUiState, ReviewEvent> {

    override fun invoke(state: ReviewUiState, intent: ReviewEvent) = when (intent) {
        is ReviewEvent.RatingSelected -> {
            val newReview = state
                .review
                ?.copy(rating = intent.rating)
                ?: ReviewRatingUiState(rating = intent.rating)

            state.copy(
                errors = reviewValidator.validate(review = newReview),
                review = newReview
            )
        }

        is ReviewEvent.DescriptionChanged -> {
            val newReview = state
                .review
                ?.copy(description = intent.description)
                ?: ReviewRatingUiState(description = intent.description)

            state.copy(
                errors = reviewValidator.validate(review = newReview),
                review = newReview
            )
        }

        ReviewEvent.SubmitReview -> {
            val newReview = state
                .review
                ?.copy(synchronizing = true)
                ?: ReviewRatingUiState(synchronizing = true)

            state.copy(review = newReview)
        }

        ReviewEvent.ReviewSubmitted -> {
            val newReview = state
                .review
                ?.copy(synchronizing = false)
                ?: ReviewRatingUiState(synchronizing = false)

            state.copy(review = newReview)
        }
    }
}
