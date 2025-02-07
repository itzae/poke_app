package com.itgonca.pokeapp.di

import com.itgonca.pokeapp.domain.repository.PokemonRepository
import com.itgonca.pokeapp.domain.usecase.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(pokemonRepository: PokemonRepository) =
        GetPokemonListUseCase(pokemonRepository)
}