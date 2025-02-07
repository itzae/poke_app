package com.itgonca.pokeapp.data.remote.repository

import com.itgonca.pokeapp.data.remote.PokemonApi
import com.itgonca.pokeapp.domain.model.Pokemon
import com.itgonca.pokeapp.domain.model.PokemonDetail
import com.itgonca.pokeapp.domain.model.toDomain
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val dispatcher: CoroutineDispatcher
) : PokemonRepository {
    override suspend fun getPokemonsList(): List<Pokemon> {
        return withContext(dispatcher) { pokemonApi.fetchPokemons().pokemons.map { it.toDomain() } }
    }

    override suspend fun getPokemonDetail(pokemonId: String): PokemonDetail =
        withContext(dispatcher) { pokemonApi.fetchPokemonDetail(pokemonId).toDomain()}


}