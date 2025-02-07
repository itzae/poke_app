package com.itgonca.pokeapp.ui.home

import androidx.compose.foundation.clickable
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
import com.itgonca.pokeapp.ui.PokemonType
import com.itgonca.pokeapp.ui.components.ChipCustom
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String,
    types: List<PokemonType>,
    onItemClick: (String) -> Unit = {}
) {
    Card(
        modifier.clickable { onItemClick(name) },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(PokeAppTheme.dimens.space8)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            types.map { type ->
                ChipCustom(text = type.name, backgroundColor = type.color)
            }
        }
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            model = imageUrl,
            contentDescription = "Pokemon image"
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = PokeAppTheme.dimens.space8),
            text = name
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PokemonItemPreview() {
    PokeAppTheme {
        PokemonItem(name = "", imageUrl = "", types = emptyList())
    }
}