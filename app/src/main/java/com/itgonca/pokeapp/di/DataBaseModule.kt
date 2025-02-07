package com.itgonca.pokeapp.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.itgonca.pokeapp.data.local.AppDataBase
import com.itgonca.pokeapp.data.local.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDataBase::class.java,
            name = "poke_app_database"
        ).build()
    }

    @Singleton
    @Provides
    fun providesPokemonDao(db: AppDataBase): PokemonDao = db.pokemonDao()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()
}