package com.itgonca.pokeapp.domain.model

import com.itgonca.pokeapp.data.remote.response.PokemonResponse

data class Pokemon(
    val name: String = "",
    val imageUrl: String = "",
    val types: List<String> = emptyList()
)

fun PokemonResponse.Pokemon.toDomain() = with(this) {
    Pokemon(name = name)
}
