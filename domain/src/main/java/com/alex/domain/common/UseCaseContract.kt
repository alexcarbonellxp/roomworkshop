package com.alex.domain.common

interface UseCaseContract<R, P> {

    suspend fun func(params: P): R

    fun run(success: (R) -> Unit, error: (Throwable) -> Unit, params: P)

    fun onDestroy()
}
