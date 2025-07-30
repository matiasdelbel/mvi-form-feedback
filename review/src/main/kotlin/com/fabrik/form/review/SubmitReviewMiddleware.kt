package com.fabrik.form.review

import com.fabrik.mvi.Middleware
import kotlinx.coroutines.delay

fun submitReviewMiddleware() = Middleware<ReviewUiState, ReviewEvent, ReviewEvent.SubmitReview> { intent ->
    delay(timeMillis = 2000)
    dispatch(intent = ReviewEvent.ReviewSubmitted)
}
