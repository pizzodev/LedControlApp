package com.teamdue.educampapp.data.network.entities

import com.teamdue.educampapp.data.network.dto.LedStatusDto

data class LedStatusEntity(
    val ledStatus: Boolean
) {
    override fun toString(): String {
        return ledStatus.toString()
    }
    fun toLedStatusDto(): LedStatusDto {
        return LedStatusDto(
            ledStatus = this.ledStatus
        )
    }
}