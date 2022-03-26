package ua.selin.smsbroadcaster.feature.fetcher.data.entity

import androidx.annotation.Keep
import ua.selin.smsbroadcaster.feature.fetcher.domain.entity.Broadcast

@Keep
data class ApiBroadcast(
    val text: String,
    val phones: List<String>
) {
    fun asDomain() = Broadcast(smsBody = text, phones = phones)
}
