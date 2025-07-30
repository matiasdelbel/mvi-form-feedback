package com.fabrik.mvi

import kotlinx.coroutines.flow.StateFlow

/**
 * Contract for managing state and reacting to events in a unidirectional data flow architecture.
 *
 * Implement this interface to expose a reactive UI [state] and handle [Event]s that trigger
 * changes to the state or side effects.
 *
 * @param State The type representing the UI state.
 * @param Event The type representing the user or system events (intents).
 */
interface StateHolder<State, Event> {

    /**
     * A [kotlinx.coroutines.flow.StateFlow] that emits the current UI state and any updates to it.
     *
     * This should be observed by the UI layer to render the latest state.
     */
    val state: StateFlow<State>

    /**
     * Handles an incoming [event] and updates the [state] accordingly.
     *
     * Implementations should treat this method as the main entry point for user actions
     * or system events, and should trigger state transitions or side effects in response.
     *
     * @param event The event to be processed.
     */
    fun onIntent(event: Event)
}
