package com.paulomoura.pokedexcomposeclean.presentation.pokemonlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.paulomoura.pokedexcomposeclean.presentation.pokemonlist.composable.ListPokemon
import org.koin.androidx.compose.getViewModel

@Composable
fun PokemonListScreen() {
    val viewModel: PokemonListViewModel = getViewModel()
    val pokemonListState by viewModel.uiState.collectAsStateWithLifecycle()
    if (pokemonListState.loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }
    if (pokemonListState.error.isNotBlank()) {
        Text(text = pokemonListState.error)
    }
    if (pokemonListState.pokemonListItems.isNotEmpty()) {
        ListPokemon(pokemonListState.pokemonListItems)
    }
}

//add preview