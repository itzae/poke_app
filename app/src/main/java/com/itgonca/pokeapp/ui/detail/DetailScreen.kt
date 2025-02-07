package com.itgonca.pokeapp.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.itgonca.pokeapp.ui.PokemonState
import com.itgonca.pokeapp.ui.components.ChipCustom
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    pokemonState: PokemonState = PokemonState(),
    onBack: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBarPokemon(onBack = onBack) }) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddingValues)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PokeAppTheme.dimens.space16),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = PokeAppTheme.dimens.space8)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PokeAppTheme.dimens.space16),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = pokemonState.name,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        pokemonState.types.map {
                            ChipCustom(
                                text = it.name,
                                backgroundColor = it.color
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        pokemonState.stats.map {
                            Row(horizontalArrangement = Arrangement.spacedBy(PokeAppTheme.dimens.space16)) {
                                Text(text = it.name)
                                Text(text = it.value)
                            }
                        }
                    }
                    AsyncImage(
                        modifier = Modifier.size(100.dp),
                        model = pokemonState.imageUrl,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPokemon(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = "Detalle", color = MaterialTheme.colorScheme.onPrimary) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}


@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    PokeAppTheme {
        DetailScreen(pokemonState = PokemonState(name = "Charizard", types = listOf()))
    }
}