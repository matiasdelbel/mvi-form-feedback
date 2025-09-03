package com.fabrik.form.review

data class ReviewUiState<ItemId>(
    val item: ReviewItemUiState<ItemId>,
    val review: ReviewRatingUiState? = null,
    val errors: ReviewError? = null,
)

data class ReviewItemUiState<ItemId>(
    val itemId: ItemId,
    val itemName: String,
    val shortDescription: String,
    val imageUrl: String,
)

data class ReviewRatingUiState(
    val rating: Int = 0,
    val description: String = "",
    val maxRating: Int = 5,
    val synchronizing: Boolean = false,
)

val MockReviewItemUiState = ReviewItemUiState(
    itemId = "",
    itemName = "Brand new California blue t-shirt",
    shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    imageUrl = "https://www.fietsenplaats.nl/cdn/shop/files/Cortego-damesfiets-zwart-plus-1.jpg",
)

val MockReviewRatingUiState = ReviewRatingUiState(
    rating = 3,
    description = "Here goes a small review of the product that we have just bought: The product works as expected, and the customer service is very helpful."
)
