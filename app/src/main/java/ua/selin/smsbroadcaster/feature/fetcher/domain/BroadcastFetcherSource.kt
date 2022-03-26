package ua.selin.smsbroadcaster.feature.fetcher.domain

import ua.selin.smsbroadcaster.feature.fetcher.domain.entity.Broadcast

interface BroadcastFetcherSource {
    suspend fun fetch(token: String): Broadcast
}
