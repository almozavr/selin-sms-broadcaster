package ua.selin.smsbroadcaster.feature.fetcher.data

import ua.selin.smsbroadcaster.feature.fetcher.domain.BroadcastFetcherSource
import ua.selin.smsbroadcaster.feature.fetcher.domain.entity.Broadcast

class BroadcastFetcherApiSource(
    private val apiService: BroadcastApiService,
) : BroadcastFetcherSource {

    override suspend fun fetch(token: String): Broadcast =
        apiService.fetchBroadcast(token).asDomain()
}
