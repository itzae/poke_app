package com.itgonca.pokeapp.domain.repository

import com.itgonca.pokeapp.domain.model.Pokemon
import com.itgonca.pokeapp.domain.model.PokemonDetail

interface PokemonRepository {
    suspend fun getPokemonsList(): List<Pokemon>
    suspend fun getPokemonDetail(pokemonId: String): PokemonDetail
}