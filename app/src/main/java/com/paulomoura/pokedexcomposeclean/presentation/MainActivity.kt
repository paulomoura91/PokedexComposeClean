package com.paulomoura.pokedexcomposeclean.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.paulomoura.pokedexcomposeclean.presentation.pokemondetail.PokemonDetailScreen
import com.paulomoura.pokedexcomposeclean.presentation.pokemonlist.PokemonListScreen
import com.paulomoura.pokedexcomposeclean.presentation.ui.theme.PokedexComposeCleanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeCleanTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = Route.PokemonList.value) {
                        composable(route = Route.PokemonList.value) {
                            PokemonListScreen(navController = navController)
                        }
                        composable(
                            route = Route.PokemonDetail.routeWithPokemonNumberArg(),
                            arguments = listOf(navArgument(Route.PokemonDetail.POKEMON_NUMBER_ARG) { type = NavType.IntType })
                        ) {
                            PokemonDetailScreen(it.arguments?.getInt(Route.PokemonDetail.POKEMON_NUMBER_ARG))
                        }
                    }
                }
            }
        }
    }
}

sealed class Route(val value: String) {
    object PokemonList : Route("pokemon_list")
    object PokemonDetail : Route("pokemon_detail") {
        const val POKEMON_NUMBER_ARG = "pokemonNumber"
        fun routeWithPokemonNumberArg() = "$value/{$POKEMON_NUMBER_ARG}"
        fun navigateWithPokemonNumberArg(pokemonNumber: Int) = "$value/$pokemonNumber"
    }
}