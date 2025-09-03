This project demonstrates a **pure MVI (Model-View-Intent)** architecture in Android using **Jetpack Compose** and **StateFlow**.  
It implements a review flow feature as an example, highlighting a clear separation between **state, intents, and side effects**.

## Features
- **Immutable UI state** represented as a single source of truth.
- **Intents** as the only way to request state changes.
- **Side effects** handled asynchronously and separately.
- **Composable ViewModels** for modular and reusable logic.
- Example **review flow**: landing, rating, and summary screens.
- **Jetpack Compose navigation** integrated with the MVI architecture.

## Architecture Overview
### ViewModel
The `ViewModel<S, I, E>` exposes:
- `state: StateFlow<S>` → current UI state
- `effects: SharedFlow<E>` → one-off side effects
- `onIntent(intent: I)` → dispatch intents

### Reducer
- Pure function that maps `(state, intent) -> new state`.
- Optionally emits side effects to be handled separately.

### SideEffectHandler
- Handles asynchronous or one-off operations (network calls, navigation, toasts).
- Can dispatch new intents back to the ViewModel.

## Tech Stack
- Kotlin
- Jetpack Compose
- StateFlow + ViewModel
- Hilt (for DI)
- Coil (for image loading)
- Material 3

## Advantages of Pure MVI
- Predictable state changes
- Testable reducers and side effects
- Composable and modular feature development
- UI-agnostic architecture compatible with Compose or XML

## Feedback & Contributions
Feel free to open issues or pull requests if you'd like to improve the project or discuss ideas!

## License
This project is MIT Licensed.