package com.fabrik.form.review

import com.fabrik.mvi.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(
    reviewReducer: ReviewReducer,
    reviewSideEffectHandler: ReviewSideEffectHandler
) : ViewModel<ReviewUiState<String>, ReviewIntent, ReviewSideEffect>(
    initialState = ReviewUiState(item = EmptyItemUiState),
    reducer = reviewReducer,
    sideEffectHandler = reviewSideEffectHandler
)

private val EmptyItemUiState = ReviewItemUiState(
    itemId = "3489",
    itemName = "Cortego City Damesfiets Plus 28 Inch - 7 Versnellingen",
    shortDescription = "Vanaf het moment dat je op de Cortego City damesfiets in mat-zwart stapt, voel je het verschil. Het verstelbare stuur en zadel zorgen voor een ergonomische zithouding.",
    imageUrl = "https://www.fietsenplaats.nl/cdn/shop/files/Cortego-damesfiets-zwart-plus-1.jpg"
)
