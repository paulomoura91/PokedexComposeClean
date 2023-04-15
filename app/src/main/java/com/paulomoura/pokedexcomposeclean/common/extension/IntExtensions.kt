package com.paulomoura.pokedexcomposeclean.common.extension

fun Int.toPokemonNumber() = "Nº ${String.format("%03d", this)}"