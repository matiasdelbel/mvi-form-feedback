package com.fabrik.mvi

interface IntentScope<State : Any, Intent : Any> {

    val state: State

    fun dispatch(intent: Intent)
}
