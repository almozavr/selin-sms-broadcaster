package ua.selin.smsbroadcaster.di

import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.koin.dsl.module
import ua.selin.smsbroadcaster.BuildConfig
import ua.selin.smsbroadcaster.shared.exception.data.CrashlyticsExceptionHandler
import ua.selin.smsbroadcaster.shared.exception.data.LogExceptionHandler
import ua.selin.smsbroadcaster.shared.exception.data.MainExceptionHandler
import ua.selin.smsbroadcaster.shared.exception.domain.ExceptionHandler

val exceptionsModule = module {
    single { FirebaseCrashlytics.getInstance() }

    single {
        val exceptionHandlers = mutableListOf<ExceptionHandler>()
        if (BuildConfig.LOGGER_ENABLED) {
            exceptionHandlers.add(LogExceptionHandler())
        }
        exceptionHandlers.add(
            CrashlyticsExceptionHandler(get())
        )
        exceptionHandlers
    }
    single<ExceptionHandler> { MainExceptionHandler(get()) }
}
