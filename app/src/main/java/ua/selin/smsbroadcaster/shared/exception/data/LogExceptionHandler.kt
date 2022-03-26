package ua.selin.smsbroadcaster.shared.exception.data

import timber.log.Timber
import ua.selin.smsbroadcaster.shared.exception.domain.ExceptionHandler

class LogExceptionHandler : ExceptionHandler {

    override fun handle(error: Throwable) {
        Timber.w(error)
    }
}
