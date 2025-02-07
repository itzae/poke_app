package com.itgonca.pokeapp.data.repository

import com.itgonca.pokeapp.data.local.PokemonDao
import com.itgonca.pokeapp.data.local.toEntity
import com.itgonca.pokeapp.data.remote.PokemonApi
import com.itgonca.pokeapp.domain.model.Pokemon
import com.itgonca.pokeapp.domain.model.PokemonDetail
import com.itgonca.pokeapp.domain.model.toDomain
import com.itgonca.pokeapp.domain.model.toPokemonDomain
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: PokemonDao,
    private val dispatcher: CoroutineDispatcher
) : PokemonRepository {
    override suspend fun getPokemonsList(): List<Pokemon> = withContext(dispatcher) {
        val allPokemonsLocal = pokemonDao.getAllPokemons().first()
        val result = if (allPokemonsLocal?.isEmpty() == true) {
            pokemonApi.fetchPokemons().pokemons.map { it.toDomain() }
        } else {
            allPokemonsLocal?.map { it.toPokemonDomain() }
        }
        result ?: emptyList()
    }

    override suspend fun getPokemonDetail(pokemonId: String): PokemonDetail =
        withContext(dispatcher) {
            val localPokemon = pokemonDao.getPokemonById(pokemonId).first()
            val result = if (localPokemon == null) {
                val responseRemote = pokemonApi.fetchPokemonDetail(pokemonId)
                pokemonDao.insertUser(responseRemote.toEntity())
                responseRemote.toDomain()
            } else {
                localPokemon.toDomain()
            }
            result
        }

    override fun searchPokemon(pokemonId: String): Flow<List<Pokemon>> =
        pokemonDao.getPokemonsById(pokemonId)
            .map {
                it.map { pokemonEntity -> pokemonEntity.toPokemonDomain() }
            }.flowOn(dispatcher)

}