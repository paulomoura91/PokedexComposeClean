package com.paulomoura.pokedexcomposeclean.domain.usecase

import com.paulomoura.pokedexcomposeclean.common.Response
import com.paulomoura.pokedexcomposeclean.data.remote.ApiException
import com.paulomoura.pokedexcomposeclean.data.remote.dto.toPokemonListItem
import com.paulomoura.pokedexcomposeclean.domain.model.PokemonListItem
import com.paulomoura.pokedexcomposeclean.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke() = flow {
        try {
            emit(Response.Loading())
            emit(Response.Success(getPokemonListItems()))
        } catch (exception: Exception) {
            emit(Response.Error(ApiException(exception)))
        }
    }

    private suspend fun getPokemonListItems(): List<PokemonListItem> {
        val pokemonDTOs = pokemonRepository.getPokemons()
        return pokemonDTOs.map { it.toPokemonListItem() }
    }
}