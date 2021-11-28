package com.suleymancelik.marvelapp.data.extension

sealed class ServiceResult<T> {
    open fun get(): T? = null

    fun getOrThrow(): T = when (this) {
        is SuccessResult -> get()
        is LoginFail -> throw throwable
        is ServerError -> throw throwable
        is EmptyResult -> throw throwable
        is NetworkError -> throw throwable
    }
}

data class SuccessResult<T>(val data: T) : ServiceResult<T>() {
    override fun get(): T = data
}

data class LoginFail<T>(val throwable: Throwable) : ServiceResult<T>()
data class ServerError<T>(val throwable: Throwable) : ServiceResult<T>()
data class NetworkError<T>(val throwable: Throwable) : ServiceResult<T>()
data class EmptyResult<T>(val throwable: Throwable) : ServiceResult<T>()

class NetworkErrorException : Throwable()

class ServiceErrorException : Throwable()

class LoginException : Throwable()

class EmptyListException : Throwable()

class ServiceErrorExceptionWithMessage(var errorMessage: String) : Throwable()