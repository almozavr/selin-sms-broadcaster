package ua.selin.smsbroadcaster.feature.sender.domain.entity

import ua.selin.smsbroadcaster.shared.entity.Status

data class SmsSendStatus(
    val body: String,
    val phones: List<String>,
    val sent: Int,
    val status: Status
)
