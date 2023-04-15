package com.paulomoura.pokedexcomposeclean.presentation.pokemondetail

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
import com.paulomoura.pokedexcomposeclean.domain.model.Pokemon
import com.paulomoura.pokedexcomposeclean.presentation.pokemondetail.composable.DetailPokemon
import com.paulomoura.pokedexcomposeclean.presentation.ui.theme.PokedexComposeCleanTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun PokemonDetailScreen() {
    val viewModel: PokemonDetailViewModel = getViewModel()
    val pokemonDetailState by viewModel.uiState.collectAsStateWithLifecycle()
    if (pokemonDetailState.loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    if (pokemonDetailState.error.isNotBlank()) {
        Text(text = pokemonDetailState.error)
    }
    pokemonDetailState.pokemon?.let { DetailPokemon(pokemon = it) }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PokemonDetailScreenPreview() {
    PokedexComposeCleanTheme {
        DetailPokemon(
            pokemon = Pokemon(
                name = "Mewtwo",
                number = 150,
                imageUrl = "",
                description = "Mewtwo description",
                types = listOf("psychic"),
                evolutions = listOf(
                    Pokemon(
                        name = "Mewtwo",
                        number = 150,
                        imageUrl = "",
                        description = "Mewtwo description",
                        types = listOf("psychic")
                    )
                )
            )
        )
    }
}