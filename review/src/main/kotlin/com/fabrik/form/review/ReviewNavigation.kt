package com.fabrik.form.review

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.fabrik.design.theme.spacers
import com.fabrik.form.review.ui.ReviewLandingPane
import com.fabrik.form.review.ui.ReviewRatingPane
import com.fabrik.form.review.ui.ReviewSummaryPane
import com.fabrik.mvi.StateHolder

fun NavGraphBuilder.review(navController: NavController, reviewStateHolderFactory: ReviewStateHolderFactory) {
    navigation(
        route = ReviewRoute,
        startDestination = ReviewLandingRoute
    ) {
        reviewLanding(navController, reviewStateHolderFactory)
        reviewRating(navController, reviewStateHolderFactory)
        reviewSummary(navController, reviewStateHolderFactory)
    }
}

typealias ReviewStateHolderFactory = @Composable (parentEntry: NavBackStackEntry) -> StateHolder<ReviewUiState, ReviewEvent>

internal fun NavGraphBuilder.reviewLanding(
    navController: NavController,
    reviewStateHolderFactory: ReviewStateHolderFactory
) {
    composable(ReviewLandingRoute) { entry ->
        val parentEntry = remember(entry) { navController.getBackStackEntry(route = ReviewRoute) }
        val stateHolder = reviewStateHolderFactory(parentEntry)
        val state = stateHolder.state.collectAsState().value

        ReviewLandingPane(
            state = state.item,
            onStartReview = {
                navController.navigate(ReviewRatingRoute)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MaterialTheme.spacers.md)
        )
    }
}

internal fun NavGraphBuilder.reviewRating(
    navController: NavController,
    reviewStateHolderFactory: ReviewStateHolderFactory
) {
    composable(ReviewRatingRoute) { entry ->
        val parentEntry = remember(entry) { navController.getBackStackEntry(route = ReviewRoute) }
        val stateHolder = reviewStateHolderFactory(parentEntry)
        val state = stateHolder.state.collectAsState().value

        ReviewRatingPane(
            state = state.review ?: ReviewRatingUiState(),
            errors = state.errors,
            onRatingSelected = { rating ->
                stateHolder.onIntent(event = ReviewEvent.RatingSelected(rating))
            },
            onDescriptionChanged = { description ->
                stateHolder.onIntent(event = ReviewEvent.DescriptionChanged(description))
            },
            onReviewFinished = {
                navController.navigate(ReviewSummaryRoute)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MaterialTheme.spacers.md)
        )
    }
}

internal fun NavGraphBuilder.reviewSummary(
    navController: NavController,
    reviewStateHolderFactory: ReviewStateHolderFactory
) {
    composable(ReviewSummaryRoute) { entry ->
        val parentEntry = remember(entry) { navController.getBackStackEntry(route = ReviewRoute) }
        val stateHolder = reviewStateHolderFactory(parentEntry)
        val state = stateHolder.state.collectAsState().value

        ReviewSummaryPane(
            state = state.review ?: ReviewRatingUiState(),
            onChangeReview = { navController.popBackStack() },
            onSubmitReview = { stateHolder.onIntent(event = ReviewEvent.SubmitReview) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MaterialTheme.spacers.md)
        )
    }
}

const val ReviewRoute = "review"
private const val ReviewLandingRoute = "review/landing"
private const val ReviewRatingRoute = "review/rating"
private const val ReviewSummaryRoute = "review/summary"
