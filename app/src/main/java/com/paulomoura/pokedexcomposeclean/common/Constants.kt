package com.paulomoura.pokedexcomposeclean.common

object Constants {

    object LogTags {
        const val KTOR = "Ktor"
    }

    object ApiRoutes {
        private const val BASE_URL = "http://192.168.15.2:8000"
        const val POKEMONS = "$BASE_URL/pokemon"
        //const val POKEMON = "$POKEMONS/$POKEMON_NUMBER"
    }

    /*object ApiParams {
        const val POKEMON_NUMBER = "number"
    }*/

    const val ERROR_POKEMON_LIST_STATE = "Error at listing the Pokémons"
    const val ERROR_POKEMON_DETAIL_STATE = "Error at showing Pokémon info"
}