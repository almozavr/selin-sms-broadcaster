package ua.selin.smsbroadcaster.di

import androidx.work.WorkManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ua.selin.smsbroadcaster.feature.sender.data.SendSmsResultReceiver
import ua.selin.smsbroadcaster.feature.sender.data.WorkManagerSmsRepository
import ua.selin.smsbroadcaster.feature.sender.domain.SmsRepository

val senderModule = module {
    single { WorkManager.getInstance(androidContext()) }
    factory<SmsRepository> { WorkManagerSmsRepository(get()) }
    single(createdAtStart = true) { SendSmsResultReceiver(androidContext(), get()) }
}
