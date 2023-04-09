package com.paulomoura.pokedexcomposeclean

import android.app.Application
import com.paulomoura.pokedexcomposeclean.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PokedexComposeClean : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokedexComposeClean)
            modules(appModule)
        }
    }
}