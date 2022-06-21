package com.teamdue.educampapp.data.network.dto

import com.teamdue.educampapp.data.network.entities.PojoEntity

data class PojoDto(
    val ledStatus: Boolean
) {
    fun toPojoEntity(): PojoEntity {
        return PojoEntity(
            ledStatus = this.ledStatus
        )
    }
}