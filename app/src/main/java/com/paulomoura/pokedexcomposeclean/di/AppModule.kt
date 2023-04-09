package com.paulomoura.pokedexcomposeclean.di

import android.util.Log
import com.paulomoura.pokedexcomposeclean.data.remote.service.PokemonApiService
import com.paulomoura.pokedexcomposeclean.data.remote.service.PokemonApiServiceImpl
import com.paulomoura.pokedexcomposeclean.data.repository.PokemonRepositoryImpl
import com.paulomoura.pokedexcomposeclean.domain.repository.PokemonRepository
import com.paulomoura.pokedexcomposeclean.domain.usecase.GetPokemonUseCase
import com.paulomoura.pokedexcomposeclean.domain.usecase.GetPokemonsUseCase
import com.paulomoura.pokedexcomposeclean.presentation.pokemondetail.PokemonDetailViewModel
import com.paulomoura.pokedexcomposeclean.presentation.pokemonlist.PokemonListViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single {
        HttpClient(Android) {
            install(JsonFeature) {
                val json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = false
                }
                serializer = KotlinxSerializer(json)
            }
            //arrumar log
            install(Logging) {
                logger = @OptIn(KtorExperimentalAPI::class) Logger.ANDROID
                level = LogLevel.ALL
            }
            install(ResponseObserver) {
                onResponse { response ->
                    Log.i("Ktor HTTP status:", "${response.status.value}")
                }
            }
        }
    }

    single<PokemonApiService> {
        PokemonApiServiceImpl(get())
    }

    single<PokemonRepository> {
        PokemonRepositoryImpl(get())
    }

    single {
        GetPokemonsUseCase(get())
    }

    single {
        GetPokemonUseCase(get())
    }

    viewModelOf(::PokemonListViewModel)

    viewModelOf(::PokemonDetailViewModel)
}