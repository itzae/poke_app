package com.itgonca.pokeapp.domain.model

import com.itgonca.pokeapp.data.local.PokemonEntity
import com.itgonca.pokeapp.data.remote.response.PokemonDetailResponse

data class PokemonDetail(
    val name: String = "",
    val stats: List<Stats> = emptyList(),
    val moves: String = "",
    val types: List<String> = emptyList(),
    val imageUrl: String = ""
) {
    data class Stats(
        val name: String = "",
        val value: String = ""
    )
}

fun PokemonDetailResponse.toDomain() = with(this) {
    PokemonDetail(
        name = name,
        types = types.map { it.type.name },
        imageUrl = sprites.frontDefault
    )
}

fun PokemonEntity.toDomain() = with(this) {
    PokemonDetail(
        name = name,
        types = types,
        imageUrl = imageUrl,
        stats = stats.map { PokemonDetail.Stats(name = it.name, value = it.value) }
    )
}

fun PokemonEntity.toPokemonDomain() = with(this) {
    Pokemon(
        name = name,
        types = types,
        imageUrl = imageUrl,
    )
}