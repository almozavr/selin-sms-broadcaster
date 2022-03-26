package ua.selin.smsbroadcaster.feature.fetcher.domain

import ua.selin.smsbroadcaster.feature.fetcher.domain.entity.Credentials

interface CredentialsSource {
    suspend fun get(): Credentials?
    suspend fun put(credentials: Credentials)
}
