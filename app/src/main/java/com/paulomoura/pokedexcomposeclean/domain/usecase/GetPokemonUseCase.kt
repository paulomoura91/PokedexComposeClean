package com.paulomoura.pokedexcomposeclean.domain.usecase

import com.paulomoura.pokedexcomposeclean.domain.repository.PokemonRepository

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    suspend fun getPokemon(number: Int) = pokemonRepository.getPokemon(number)
}