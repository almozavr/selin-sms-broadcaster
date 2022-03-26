package ua.selin.smsbroadcaster.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ua.selin.smsbroadcaster.feature.permission.data.WarderPermissionService
import ua.selin.smsbroadcaster.feature.permission.domain.PermissionService

val permissionsModule = module {
    factory<PermissionService> { WarderPermissionService(androidContext()) }
}
