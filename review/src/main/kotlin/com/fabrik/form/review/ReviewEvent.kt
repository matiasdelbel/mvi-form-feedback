package com.fabrik.form.review

sealed interface ReviewEvent {

    data class RatingSelected(val rating: Int) : ReviewEvent

    data class DescriptionChanged(val description: String) : ReviewEvent

    object SubmitReview : ReviewEvent

    object ReviewSubmitted : ReviewEvent // TODO
}
