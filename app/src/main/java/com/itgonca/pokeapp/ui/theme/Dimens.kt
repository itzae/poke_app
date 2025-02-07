package com.itgonca.pokeapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val space8: Dp = 8.dp,
    val space16: Dp = 16.dp,

    val cornerMedium:Dp = 16.dp,
    val cornerExtraSmall:Dp = 4.dp
)

internal val LocalDimens = staticCompositionLocalOf { Dimens() }

object PokeAppTheme {
    val dimens:Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current
}