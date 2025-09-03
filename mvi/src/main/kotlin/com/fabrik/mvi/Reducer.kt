package com.fabrik.mvi

fun interface Reducer<S, I, E> {

    fun reduce(state: S, intent: I, throwSideEffect: (E) -> Unit): S
}
