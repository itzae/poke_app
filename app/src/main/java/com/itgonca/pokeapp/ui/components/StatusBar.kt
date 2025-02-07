package com.itgonca.pokeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun StatusBar(modifier: Modifier = Modifier, value: Float,color: Color) {
    val progress = remember { value / 100f }
    Box {
        Box(
            modifier = Modifier
                .padding(PokeAppTheme.dimens.space8)
                .fillMaxWidth(progress)
                .height(10.dp)
                .background(color = color, shape = CircleShape)
        )
        Box(
            modifier = modifier
                .padding(PokeAppTheme.dimens.space8)
                .fillMaxWidth()
                .height(10.dp)
                .background(color = color.copy(alpha = 0.3f), shape = CircleShape)
        )
    }
}