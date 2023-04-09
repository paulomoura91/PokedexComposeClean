package com.paulomoura.pokedexcomposeclean.presentation.pokemondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulomoura.pokedexcomposeclean.common.Constants.ERROR_POKEMON_DETAIL_STATE
import com.paulomoura.pokedexcomposeclean.common.Response
import com.paulomoura.pokedexcomposeclean.domain.usecase.GetPokemonUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val getPokemonUseCase: GetPokemonUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonDetailState())
    val uiState = _uiState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), PokemonDetailState())

    init {
        getPokemon(2)
    }

    private fun getPokemon(number: Int) {
        viewModelScope.launch {
            getPokemonUseCase.getPokemon(number).onEach { response ->
                _uiState.value = when (response) {
                    is Response.Loading -> PokemonDetailState(loading = true)
                    is Response.Success -> response.data?.let { PokemonDetailState(pokemon = it) }
                        ?: PokemonDetailState(error = ERROR_POKEMON_DETAIL_STATE)
                    is Response.Error -> PokemonDetailState(error = ERROR_POKEMON_DETAIL_STATE)
                }
            }.collect()
        }
    }
}