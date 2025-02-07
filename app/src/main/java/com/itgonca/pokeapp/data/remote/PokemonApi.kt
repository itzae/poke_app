package com.itgonca.pokeapp.data.remote

import com.itgonca.pokeapp.data.remote.response.PokemonDetailResponse
import com.itgonca.pokeapp.data.remote.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemons(): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun fetchPokemonDetail(@Path("id") pokemonId: String): PokemonDetailResponse
}