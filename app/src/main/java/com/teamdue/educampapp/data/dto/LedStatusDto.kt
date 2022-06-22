package com.teamdue.educampapp.data.network.dto

import com.google.gson.Gson
import com.teamdue.educampapp.data.network.entities.LedStatusEntity

data class LedStatusDto(
    val ledStatus: Boolean
) {
    fun toLedStatusEntity(): LedStatusEntity {
        return LedStatusEntity(
            ledStatus = this.ledStatus
        )
    }

    companion object {
        fun fromString(value: String): LedStatusDto? {
            return Gson().fromJson(
                value, LedStatusDto::class.java
            )
        }
    }
}