package com.itgonca.pokeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = YellowPikachu,
    secondary = PokemonBlue,
    tertiary = Pink80,
    background = DeepBlack,
    onBackground = GreyLight,
    surface = EerieBlack,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = GreyLight,
    onBackground = SoftBlack,
    surface = Color.White,
    onSurface = SoftBlack
)

@Composable
fun PokeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dimens: Dimens = PokeAppTheme.dimens,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(LocalDimens provides dimens){
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}