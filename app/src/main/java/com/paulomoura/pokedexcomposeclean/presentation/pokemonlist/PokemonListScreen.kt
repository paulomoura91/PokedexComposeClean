package com.paulomoura.pokedexcomposeclean.presentation.pokemonlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.paulomoura.pokedexcomposeclean.domain.model.PokemonListItem
import com.paulomoura.pokedexcomposeclean.presentation.pokemonlist.composable.ListPokemon
import com.paulomoura.pokedexcomposeclean.presentation.ui.theme.PokedexComposeCleanTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun PokemonListScreen() {
    val viewModel: PokemonListViewModel = getViewModel()
    val pokemonListState by viewModel.uiState.collectAsStateWithLifecycle()
    val searchTextState by viewModel.searchTextState.collectAsStateWithLifecycle()
    val onValueChange = viewModel::setSearchText
    if (pokemonListState.loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    if (pokemonListState.error.isNotBlank()) {
        Text(text = pokemonListState.error)
    }
    if (pokemonListState.pokemonListItems.isNotEmpty()) {
        ListPokemon(pokemonListItems = pokemonListState.pokemonListItems, searchQuery = searchTextState, onValueChange = onValueChange)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PokemonListScreenPreview() {
    PokedexComposeCleanTheme {
        val pokemons = mutableListOf<PokemonListItem>()
        for (i in 1..50) {
            pokemons.add(PokemonListItem("Pokémon $i", i, ""))
        }
        ListPokemon(pokemonListItems = pokemons, searchQuery = "", onValueChange = { })
    }
}