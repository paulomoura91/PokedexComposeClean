package com.paulomoura.pokedexcomposeclean.domain.repository

import com.paulomoura.pokedexcomposeclean.common.Response
import com.paulomoura.pokedexcomposeclean.domain.model.Pokemon
import com.paulomoura.pokedexcomposeclean.domain.model.PokemonListItem
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemons(): Flow<Response<List<PokemonListItem>>>

    suspend fun getPokemon(number: Int): Flow<Response<Pokemon>>
}