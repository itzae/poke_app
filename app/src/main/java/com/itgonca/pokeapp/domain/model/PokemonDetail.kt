package com.itgonca.pokeapp.domain.model

import com.itgonca.pokeapp.data.remote.response.PokemonDetailResponse

data class PokemonDetail(
    val name: String="",
    val stats: Stats=Stats(),
    val moves: String="",
    val types: List<String> = emptyList(),
    val imageUrl: String = ""
) {
    data class Stats(
        val name: String="",
        val value: String=""
    )
}

fun PokemonDetailResponse.toDomain() = with(this){
    PokemonDetail(
        name = name,
        types = types.map { it.type.name },
        imageUrl = sprites.frontDefault
    )
}