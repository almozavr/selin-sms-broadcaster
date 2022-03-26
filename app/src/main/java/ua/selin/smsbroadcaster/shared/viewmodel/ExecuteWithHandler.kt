package ua.selin.smsbroadcaster.shared.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ua.selin.smsbroadcaster.shared.coroutines.executeWithHandler

suspend inline fun <R> ViewModel.executeWithHandler(block: () -> R): Result<R> =
    viewModelScope.executeWithHandler(block)
