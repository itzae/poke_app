package com.itgonca.pokeapp.ui.navigation

import kotlinx.serialization.Serializable

sealed class PokeAppScreenRoutes {
    @Serializable
    data object HomeScreen : PokeAppScreenRoutes()
    @Serializable
    data object DetailScreen : PokeAppScreenRoutes()
}