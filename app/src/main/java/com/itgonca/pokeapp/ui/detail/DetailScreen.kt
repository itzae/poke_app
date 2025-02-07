package com.itgonca.pokeapp.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.itgonca.pokeapp.R
import com.itgonca.pokeapp.ui.PokemonUi
import com.itgonca.pokeapp.ui.components.ChipCustom
import com.itgonca.pokeapp.ui.components.StatusBar
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    pokemonUi: PokemonUi = PokemonUi(),
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
                //Name and type section
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PokeAppTheme.dimens.space16),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = pokemonUi.name.replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(PokeAppTheme.dimens.space8)) {
                        pokemonUi.types.map {
                            ChipCustom(
                                text = it.name,
                                backgroundColor = it.color
                            )
                        }
                    }
                }
                //Stats and image section
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = PokeAppTheme.dimens.space16),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.fillMaxWidth(0.5f)) {
                        pokemonUi.stats.map {
                            StatProgress(
                                stat = it.name,
                                value = it.value.toFloat(),
                                color = it.color
                            )
                        }
                    }
                    Box(Modifier.fillMaxWidth(0.5f)) {
                        AsyncImage(
                            modifier = Modifier.size(100.dp),
                            model = pokemonUi.imageUrl,
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )
                    }
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
        title = {
            Text(
                text = stringResource(R.string.detail_screen_title),
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
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

@Composable
fun StatProgress(stat: String, value: Float, color: Color) {
    Column {
        Text(text = stat)
        StatusBar(value = value, color = color)
    }
}


@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    PokeAppTheme {
        DetailScreen(pokemonUi = PokemonUi(name = "Charizard", types = listOf()))
    }
}