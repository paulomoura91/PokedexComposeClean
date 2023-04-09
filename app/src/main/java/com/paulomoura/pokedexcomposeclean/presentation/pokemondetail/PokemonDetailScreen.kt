package com.paulomoura.pokedexcomposeclean.presentation.pokemondetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel

@Composable
fun PokemonDetailScreen() {
    val viewModel: PokemonDetailViewModel = getViewModel()
    val pokemonDetailState by viewModel.uiState.collectAsStateWithLifecycle()
    if (pokemonDetailState.loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }
    if (pokemonDetailState.error.isNotBlank()) {
        Text(text = pokemonDetailState.error)
    }
    pokemonDetailState.pokemon?.let {
        Text(text = it.name + " " + it.description)
    }
}

//add preview