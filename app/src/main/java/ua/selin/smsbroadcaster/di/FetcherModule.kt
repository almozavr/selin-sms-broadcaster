package ua.selin.smsbroadcaster.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import ua.selin.smsbroadcaster.feature.fetcher.data.BroadcastApiService
import ua.selin.smsbroadcaster.feature.fetcher.data.BroadcastFetcherApiSource
import ua.selin.smsbroadcaster.feature.fetcher.data.CredentialsDataStoreSource
import ua.selin.smsbroadcaster.feature.fetcher.domain.BroadcastFetcherSource
import ua.selin.smsbroadcaster.feature.fetcher.domain.CredentialsSource
import ua.selin.smsbroadcaster.feature.fetcher.domain.FetcherRepository

val fetcherModule = module {
    factory { get<Retrofit>().create(BroadcastApiService::class.java) }
    factory<BroadcastFetcherSource> { BroadcastFetcherApiSource(get()) }
    factory<CredentialsSource> { CredentialsDataStoreSource(androidContext()) }
    factory { FetcherRepository(get(), get()) }
}
