package com.itgonca.pokeapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.itgonca.pokeapp.ui.components.ChipCustom
import com.itgonca.pokeapp.ui.theme.GrassColor
import com.itgonca.pokeapp.ui.theme.PoisonColor
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun PokemonItem(modifier: Modifier = Modifier) {
    Card(
        modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            ChipCustom(text = "Grass", backgroundColor = GrassColor)
            ChipCustom(text = "Poison", backgroundColor = PoisonColor)
        }
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterHorizontally),
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 8.dp),
            text = "Name pokemon"
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PokemonItemPreview() {
    PokeAppTheme {
        PokemonItem()
    }
}