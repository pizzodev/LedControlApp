package com.teamdue.educampapp.data.network.entities

data class PojoEntity(
    val name: String,
    val email: String
) {
    fun toBeautifulString(): String {
        return "Name: $name, Email: $email"
    }
}