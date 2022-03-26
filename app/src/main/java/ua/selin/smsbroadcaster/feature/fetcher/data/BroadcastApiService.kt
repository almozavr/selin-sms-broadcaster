package ua.selin.smsbroadcaster.feature.fetcher.data

import retrofit2.http.GET
import retrofit2.http.Query
import ua.selin.smsbroadcaster.feature.fetcher.data.entity.ApiBroadcast

interface BroadcastApiService {

    @GET("/sms/bulk")
    suspend fun fetchBroadcast(@Query("apikey") token: String): ApiBroadcast
}
