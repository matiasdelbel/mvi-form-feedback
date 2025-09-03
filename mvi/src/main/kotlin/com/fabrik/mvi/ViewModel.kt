package com.fabrik.mvi

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class ViewModel<S, I : Any, E : Any>(
    initialState: S,
    private val reducer: Reducer<S, I, E>,
    private val sideEffectHandler: SideEffectHandler<S, I, E>,
) : androidx.lifecycle.ViewModel() {

    /**
     * The reactive stream representing the current UI state.
     */
    private val _uiState = MutableStateFlow(value = initialState)

    /**
     * Public [StateFlow] exposing the current UI state for observation (e.g., in Compose).
     */
    val state: StateFlow<S> = _uiState

    /**
     * Internal flow for emitting one-time effects.
     */
    private val _effects = MutableSharedFlow<E>(replay = 0, extraBufferCapacity = 1)

    /**
     * Public [SharedFlow] exposing emitted effects for one-time handling in the UI.
     */
    val effects: SharedFlow<E> = _effects.asSharedFlow()

    fun onIntent(intent: I) {
        _uiState.value = reducer.reduce(state = state.value, intent) { sideEffect ->
            handleSideEffect(sideEffect)
        }
    }

    private fun handleSideEffect(sideEffect: E) {
        viewModelScope.launch {
            sideEffectHandler.handle(state = _uiState.value, sideEffect) { newIntent ->
                onIntent(newIntent)
            }
        }
    }
}
