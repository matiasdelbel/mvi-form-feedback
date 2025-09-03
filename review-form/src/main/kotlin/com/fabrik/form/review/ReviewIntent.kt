package com.fabrik.form.review

sealed interface ReviewIntent {

    data class RatingSelected(val rating: Int) : ReviewIntent

    data class DescriptionChanged(val description: String) : ReviewIntent

    object SubmitReview : ReviewIntent

    object ReviewSubmitted : ReviewIntent
}