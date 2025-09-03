package com.fabrik.mvi

interface SideEffectHandler<S, I, E : Any> {

    suspend fun handle(state: S, effect: E, onNewIntent: (I) -> Unit)
}