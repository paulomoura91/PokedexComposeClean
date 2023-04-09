package com.paulomoura.pokedexcomposeclean.domain.repository

import com.paulomoura.pokedexcomposeclean.data.remote.dto.PokemonDTO

interface PokemonRepository {

    suspend fun getPokemons(): List<PokemonDTO>

    suspend fun getPokemon(number: Int): PokemonDTO
}