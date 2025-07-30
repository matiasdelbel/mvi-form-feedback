# MVI Form Feedback – Android Review Flow
This project demonstrates how to implement a modern review flow in Android using
**MVI**, **Jetpack Compose**, and **Navigation**.

It's part of a series where the same feature will be implemented using different architectures (MVVM and MVI), and eventually compared.

## Features
- Multi-step form using Jetpack Navigation
- Shared `ViewModel` across screens
- State management with `StateFlow`
- Live validation with error handling
- Jetpack Compose UI with previews
- Clean architecture with DI (Hilt)

## Screens
1. **Landing** – displays item information
2. **Rating** – user selects a rating and adds a description
3. **Summary** – review confirmation and submission

## Architecture
This project follows a **MVI** approach with a shared `ViewModel` scoped to the parent navigation route.
UI state is exposed via `StateFlow` and updated through event-handling sealed interface.

Validation results are stored in the state and rendered in the UI in real time.

## Tech Stack
- Kotlin
- Jetpack Compose
- StateFlow + ViewModel
- Hilt (for DI)
- Coil (for image loading)
- Material 3

## Project Structure
```markdown
review/
├── ReviewViewModel.kt
├── ReviewUiState.kt
├── ReviewReducer.kt
├── ReviewValidator.kt
├── SubmitReviewMiddleware.kt
├── pane/
│ ├── ReviewLandingPane.kt
│ ├── ReviewRatingPane.kt
│ └── ReviewSummaryPane.kt
└── ReviewNavigation.kt
```

## Feedback & Contributions
Feel free to open issues or pull requests if you'd like to improve the project or discuss ideas!

## License
MIT