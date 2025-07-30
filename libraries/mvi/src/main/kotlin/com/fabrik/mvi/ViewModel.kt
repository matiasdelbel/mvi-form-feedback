package com.fabrik.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class ViewModel<State: Any, ParentIntent: Any>(
    initialState: State,
    private val reducer: Reducer<State, ParentIntent>,
    private val middlewares: Set<@JvmSuppressWildcards Middleware<State, ParentIntent, *>>
) : ViewModel(), StateHolder<State, ParentIntent> {

    private val _state = MutableStateFlow(value = initialState)
    override val state: StateFlow<State> = _state.asStateFlow()

    override fun onIntent(intent: ParentIntent) {
        val intentScope = object: IntentScope<State, ParentIntent> {

            override val state get() = _state.value

            override fun dispatch(intent: ParentIntent) { onIntent(intent) }
        }

        viewModelScope.launch {
            middlewares
                .filter { it.intentClass == intent::class.java }
                .onEach { middleware -> middleware.onEvent(intent = intent, scope = intentScope) }
        }

        _state.value = reducer(_state.value, intent)
    }
}
