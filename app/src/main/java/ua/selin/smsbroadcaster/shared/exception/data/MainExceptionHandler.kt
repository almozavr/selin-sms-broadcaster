package ua.selin.smsbroadcaster.shared.exception.data

import ua.selin.smsbroadcaster.shared.exception.domain.ExceptionHandler

class MainExceptionHandler(
    private val exceptionHandlers: List<ExceptionHandler>
) : ExceptionHandler {

    override fun handle(error: Throwable) {
        exceptionHandlers.forEach { it.handle(error) }
    }
}
