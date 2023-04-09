package com.paulomoura.pokedexcomposeclean.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                    NavHost(navController = navController, startDestination = "list") {
                        composable("list") {
                            PokemonListScreen()
                        }
                        composable("detail") {
                            PokemonDetailScreen()
                        }
                    }
                }
            }
        }
    }
}