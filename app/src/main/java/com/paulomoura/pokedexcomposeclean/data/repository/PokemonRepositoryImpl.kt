package com.paulomoura.pokedexcomposeclean.data.repository

import com.paulomoura.pokedexcomposeclean.data.remote.dto.PokemonDTO
import com.paulomoura.pokedexcomposeclean.data.remote.service.PokemonApiService
import com.paulomoura.pokedexcomposeclean.domain.repository.PokemonRepository

class PokemonRepositoryImpl(private val pokemonApiService: PokemonApiService) : PokemonRepository {

    override suspend fun getPokemons(): List<PokemonDTO> = pokemonApiService.getPokemons()

    override suspend fun getPokemon(number: Int): PokemonDTO = pokemonApiService.getPokemon(number)
}