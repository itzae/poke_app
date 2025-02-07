package com.itgonca.pokeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.itgonca.pokeapp.ui.theme.BugColor
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun ChipCustom(modifier: Modifier = Modifier, text: String, backgroundColor: Color) {
    Box(
        modifier = modifier.background(
            color = backgroundColor,
            shape = RoundedCornerShape(PokeAppTheme.dimens.cornerExtraSmall)
        )
    ) {
        Text(
            modifier = Modifier.padding(horizontal = PokeAppTheme.dimens.space16),
            text = text,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChipCustomPreview() {
    PokeAppTheme {
        ChipCustom(text = "Flying", backgroundColor = BugColor)
    }

}