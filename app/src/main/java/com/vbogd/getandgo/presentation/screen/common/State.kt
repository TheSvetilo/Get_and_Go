package com.vbogd.getandgo.presentation.screen.common

sealed class State<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : State<T>(data)
    class Error<T>(data: T? = null, message: String) : State<T>(data, message)
    class Loading<T>(data: T? = null) : State<T>(data)
}

