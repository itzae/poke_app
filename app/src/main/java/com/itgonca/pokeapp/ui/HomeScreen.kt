package com.itgonca.pokeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.itgonca.pokeapp.R
import com.itgonca.pokeapp.ui.components.SearchTextField
import com.itgonca.pokeapp.ui.theme.PokeAppTheme
import com.itgonca.pokeapp.ui.theme.PokemonBlue

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        HomeHeader()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(PokeAppTheme.dimens.space8)
        ) {
            items(20) {
                PokemonItem(modifier = Modifier.padding(PokeAppTheme.dimens.space8))
            }
        }
    }
}

@Composable
private fun HomeHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = PokemonBlue,
                shape = RoundedCornerShape(
                    bottomStart = PokeAppTheme.dimens.cornerMedium,
                    bottomEnd = PokeAppTheme.dimens.cornerMedium
                )
            )
    ) {
        Text(
            modifier = Modifier.padding(PokeAppTheme.dimens.space16),
            text = stringResource(R.string.home_title_label),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PokeAppTheme.dimens.space16), query = ""
        ) { }

    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    PokeAppTheme {
        HomeScreen()
    }
}