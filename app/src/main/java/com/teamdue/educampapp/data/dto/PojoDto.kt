package com.teamdue.educampapp.data.network.dto

import com.teamdue.educampapp.data.network.entities.PojoEntity

data class PojoDto(
    val name: String,
    val email: String
) {
    fun toPojoEntity(): PojoEntity {
        return PojoEntity(
            name = this.name,
            email = this.email
        )
    }
}