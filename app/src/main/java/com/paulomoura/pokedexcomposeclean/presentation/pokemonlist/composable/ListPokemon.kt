package com.paulomoura.pokedexcomposeclean.presentation.pokemonlist.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.paulomoura.pokedexcomposeclean.domain.model.PokemonListItem

@Composable
fun ListPokemon(pokemonListItems: List<PokemonListItem>) {
    LazyColumn {
        items(pokemonListItems) {
            Text(text = it.name)
        }
    }
}