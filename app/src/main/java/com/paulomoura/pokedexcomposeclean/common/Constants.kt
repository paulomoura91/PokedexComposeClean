package com.paulomoura.pokedexcomposeclean.common

import com.paulomoura.pokedexcomposeclean.common.Constants.ApiParams.POKEMON_NUMBER

object Constants {

    object ApiRoutes {
        private const val BASE_URL = "http://192.168.15.2:8000"
        const val POKEMONS = "$BASE_URL/pokemon"
        const val POKEMON = "$POKEMONS/$POKEMON_NUMBER"
    }

    object ApiParams {
        const val POKEMON_NUMBER = "number"
    }
}