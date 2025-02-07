package com.itgonca.pokeapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itgonca.pokeapp.data.local.PokemonEntity.StatEntity
import com.itgonca.pokeapp.data.remote.response.PokemonDetailResponse

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val name: String,
    val imageUrl: String,
    val types: List<String>,
    val stats: List<StatEntity>,
    val moves: List<String>,
    val height: String,
    val weight: String
) {
    data class StatEntity(
        val name: String,
        val value: String
    )
}

fun PokemonDetailResponse.toEntity() = with(this) {
    PokemonEntity(
        name = name,
        imageUrl = sprites.frontDefault,
        types = types.map { it.type.name },
        stats = stats.map { StatEntity(name = it.stat.name, value = it.baseStat.toString()) },
        moves = moves.map { it.move.name },
        height = height.toString(),
        weight = weight.toString()
    )
}
