package com.teamdue.educampapp.data.network.dto

import com.teamdue.educampapp.data.network.entities.PojoEntity

data class PojoDto(
    val pojoField: String
) {
    fun toPojoEntity(): PojoEntity {
        return PojoEntity(
            pojoField = this.pojoField
        )
    }
}