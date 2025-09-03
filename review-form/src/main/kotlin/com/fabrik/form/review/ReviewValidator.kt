package com.fabrik.form.review

open class ReviewValidator {

    open fun validate(review: ReviewRatingUiState): ReviewError = ReviewError(
        rating = validate(review.rating),
        description = validate(review.description),
    )

    open fun validate(rating: Int): RatingError? = when (rating) {
        !in 1..5 -> RatingError
        else -> null
    }

    open fun validate(description: String): DescriptionError? = when {
        description.length < 10 -> DescriptionError.DescriptionTooShort
        description.length > 1000 -> DescriptionError.DescriptionTooLong
        else -> null
    }
}
