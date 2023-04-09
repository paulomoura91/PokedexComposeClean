package com.paulomoura.pokedexcomposeclean.data.remote.dto

import com.paulomoura.pokedexcomposeclean.domain.model.Pokemon
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO(
    val number: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val types: List<String>,
    val evolutions: List<Int>
)

fun PokemonDTO.toEvolution() = Pokemon(
    number = number,
    name = name,
    description = description,
    imageUrl = imageUrl,
    types = types
)

fun PokemonDTO.toPokemon(pokemons: List<PokemonDTO>): Pokemon {
    val filteredEvolutions = pokemons.filter { evolutions.contains(it.number) }.map { it.toEvolution() }
    return Pokemon(
        number = number,
        name = name,
        description = description,
        imageUrl = imageUrl,
        types = types,
        evolutions = filteredEvolutions
    )
}