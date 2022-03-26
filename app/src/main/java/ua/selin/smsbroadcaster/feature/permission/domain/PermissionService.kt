package ua.selin.smsbroadcaster.feature.permission.domain

interface PermissionService {
    suspend fun checkSendSms(): Boolean
}
