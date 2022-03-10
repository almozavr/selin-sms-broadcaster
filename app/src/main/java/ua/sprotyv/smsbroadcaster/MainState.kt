package ua.sprotyv.smsbroadcaster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainState(
    val fetchInProgress: Boolean,
    val smsBody: String,
    val smsNumbers: Int,
) : Parcelable

sealed class MainEffect
