package com.alex.domain.common

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase<R, P> : CoroutineScope, UseCaseContract<R, P> {

    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main
    private val job = Job()

    override var coroutineContext: CoroutineContext = coroutineDispatcher + job

    override fun run(success: (R) -> Unit, error: (Throwable) -> Unit, params: P) {
        launch {
            try {
                success(func(params))
            } catch (e: Throwable) {
                error(e)
            }
        }
    }

    override fun onDestroy() = job.cancel()
}
