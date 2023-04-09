package com.paulomoura.pokedexcomposeclean.data.remote.service

import com.paulomoura.pokedexcomposeclean.data.remote.dto.PokemonDTO

interface PokemonApiService {

    suspend fun getPokemons(): List<PokemonDTO>

    suspend fun getPokemon(number: Int): PokemonDTO
}