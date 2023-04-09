package com.paulomoura.pokedexcomposeclean.domain.usecase

import com.paulomoura.pokedexcomposeclean.domain.repository.PokemonRepository

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {

    suspend fun getPokemons() = pokemonRepository.getPokemons()
}