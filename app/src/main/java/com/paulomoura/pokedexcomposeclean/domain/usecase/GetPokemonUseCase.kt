package com.paulomoura.pokedexcomposeclean.domain.usecase

import com.paulomoura.pokedexcomposeclean.common.Response
import com.paulomoura.pokedexcomposeclean.data.remote.ApiException
import com.paulomoura.pokedexcomposeclean.data.remote.dto.toPokemon
import com.paulomoura.pokedexcomposeclean.domain.model.Pokemon
import com.paulomoura.pokedexcomposeclean.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke(number: Int) = flow {
        try {
            emit(Response.Loading())
            emit(Response.Success(getPokemon(number)))
        } catch (exception: Exception) {
            emit(Response.Error(ApiException(exception)))
        }
    }

    private suspend fun getPokemon(number: Int): Pokemon {
        val pokemonDTO = pokemonRepository.getPokemon(number)
        val evolutions = pokemonDTO.evolutions.map { evolutionNumber ->
            if (evolutionNumber == pokemonDTO.number) {
                pokemonDTO
            } else {
                pokemonRepository.getPokemon(evolutionNumber)
            }
        }
        return pokemonDTO.toPokemon(evolutions)
    }
}