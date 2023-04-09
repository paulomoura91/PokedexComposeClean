package com.paulomoura.pokedexcomposeclean.data.remote.service

import com.paulomoura.pokedexcomposeclean.common.Constants
import com.paulomoura.pokedexcomposeclean.data.remote.dto.PokemonDTO
import io.ktor.client.*
import io.ktor.client.request.*

class PokemonApiServiceImpl(private val httpClient: HttpClient) : PokemonApiService {

    override suspend fun getPokemons(): List<PokemonDTO> = httpClient.get { url(Constants.ApiRoutes.POKEMONS) }

    override suspend fun getPokemon(number: Int): PokemonDTO = httpClient.get {
        url(Constants.ApiRoutes.POKEMON)
        parameter(Constants.ApiParams.POKEMON_NUMBER, number)
    }
}