package com.itgonca.pokeapp.ui

import androidx.compose.ui.graphics.Color
import com.itgonca.pokeapp.domain.model.Pokemon
import com.itgonca.pokeapp.domain.model.PokemonDetail
import com.itgonca.pokeapp.ui.theme.BugColor
import com.itgonca.pokeapp.ui.theme.DarkColor
import com.itgonca.pokeapp.ui.theme.DragonColor
import com.itgonca.pokeapp.ui.theme.ElectricColor
import com.itgonca.pokeapp.ui.theme.FairyColor
import com.itgonca.pokeapp.ui.theme.FightingColor
import com.itgonca.pokeapp.ui.theme.FireColor
import com.itgonca.pokeapp.ui.theme.FlyingColor
import com.itgonca.pokeapp.ui.theme.GhostColor
import com.itgonca.pokeapp.ui.theme.GrassColor
import com.itgonca.pokeapp.ui.theme.GroundColor
import com.itgonca.pokeapp.ui.theme.IceColor
import com.itgonca.pokeapp.ui.theme.NormalColor
import com.itgonca.pokeapp.ui.theme.PoisonColor
import com.itgonca.pokeapp.ui.theme.PsychicColor
import com.itgonca.pokeapp.ui.theme.RockColor
import com.itgonca.pokeapp.ui.theme.SteelColor
import com.itgonca.pokeapp.ui.theme.WaterColor

data class PokemonState(
    val name: String = "",
    val imageUrl: String = "",
    val types: List<PokemonType> = emptyList(),
    val stats: List<StatsUi> = emptyList()
)

data class PokemonType(val name: String, val color: Color)
data class StatsUi(val name: String, val value: String, val color: Color)


fun Pokemon.toPokemonItemUi() = with(this) {
    PokemonState(
        name = name,
        imageUrl = imageUrl,
        types = types.map { getPokemonType(it) }
    )
}

fun PokemonDetail.toDetailUi() = with(this) {
    PokemonState(
        name = name,
        imageUrl = imageUrl,
        types = types.map { getPokemonType(it) },
        stats = stats.map {
            StatsUi(
                name = it.name,
                value = it.value,
                color = getStatColor(it.name)
            )
        }
    )
}

fun getStatColor(type: String) = when (type) {
    "hp" -> GrassColor
    "attack" -> FireColor
    "defense" -> ElectricColor
    "special-attack" -> FightingColor
    "special-defense" -> WaterColor
    "speed" -> IceColor
    "accuracy" -> BugColor
    "evasion" -> PoisonColor
    else -> Color.LightGray
}

fun getPokemonType(type: String) = when (type) {
    "normal" -> PokemonType(name = "Normal", color = NormalColor)
    "fighting" -> PokemonType(name = "fighting", color = FightingColor)
    "flying" -> PokemonType(name = "flying", color = FlyingColor)
    "poison" -> PokemonType(name = "poison", color = PoisonColor)
    "ground" -> PokemonType(name = "ground", color = GroundColor)
    "rock" -> PokemonType(name = "rock", color = RockColor)
    "bug" -> PokemonType(name = "bug", color = BugColor)
    "ghost" -> PokemonType(name = "ghost", color = GhostColor)
    "steel" -> PokemonType(name = "steel", color = SteelColor)
    "fire" -> PokemonType(name = "fire", color = FireColor)
    "water" -> PokemonType(name = "water", color = WaterColor)
    "grass" -> PokemonType(name = "grass", color = GrassColor)
    "electric" -> PokemonType(name = "electric", color = ElectricColor)
    "psychic" -> PokemonType(name = "psychic", color = PsychicColor)
    "ice" -> PokemonType(name = "ice", color = IceColor)
    "dragon" -> PokemonType(name = "dragon", color = DragonColor)
    "dark" -> PokemonType(name = "dark", color = DarkColor)
    "fairy" -> PokemonType(name = "fairy", color = FairyColor)
    "stellar" -> PokemonType(name = "stellar", color = NormalColor)
    else -> PokemonType(name = "Unknown", color = Color.Gray)
}

