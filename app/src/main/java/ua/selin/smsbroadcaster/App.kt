package ua.selin.smsbroadcaster

import android.app.Application
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import ua.selin.smsbroadcaster.di.exceptionsModule
import ua.selin.smsbroadcaster.di.fetcherModule
import ua.selin.smsbroadcaster.di.mainModule
import ua.selin.smsbroadcaster.di.netModule
import ua.selin.smsbroadcaster.di.permissionsModule
import ua.selin.smsbroadcaster.di.senderModule

@ExperimentalCoroutinesApi
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupLogger()
        setupDependencyInjection()
    }

    private fun setupLogger() {
        if (BuildConfig.LOGGER_ENABLED) Timber.plant(Timber.DebugTree())
    }

    private fun setupDependencyInjection(): KoinApplication =
        startKoin {
            androidContext(this@App)
            androidLogger(if (BuildConfig.LOGGER_ENABLED) Level.ERROR else Level.NONE)
            modules(
                // region main
                mainModule,
                // endregion
                // region io
                netModule,
                fetcherModule,
                senderModule,
                // endregion
                // region shared
                exceptionsModule,
                permissionsModule,
                // endregion
            )
        }
}
