package ua.selin.smsbroadcaster.feature.sender.domain

import kotlinx.coroutines.flow.Flow
import ua.selin.smsbroadcaster.feature.sender.domain.entity.SmsSendStatus

interface SmsRepository {
    fun observe(): Flow<SmsSendStatus>
    suspend fun send(body: String, phones: List<String>)
    suspend fun cancel()
}
