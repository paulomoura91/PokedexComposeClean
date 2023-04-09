package com.paulomoura.pokedexcomposeclean.domain.model

data class Pokemon(
    val number: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val types: List<String>,
    val evolutions: List<Pokemon>? = null
)