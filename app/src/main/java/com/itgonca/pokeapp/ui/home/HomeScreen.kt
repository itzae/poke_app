package com.itgonca.pokeapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.itgonca.pokeapp.R
import com.itgonca.pokeapp.ui.PokemonState
import com.itgonca.pokeapp.ui.components.SearchTextField
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun HomeScreenRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToDetail: (String) -> Unit
) {
    val pokemonList by viewModel.searchList.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    HomeScreen(
        list = pokemonList,
        query = searchQuery,
        onSearch = { id -> viewModel.searchPokemon(id) },
        onNavigateToDetail = onNavigateToDetail
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    list: List<PokemonState>,
    query: String = "",
    onSearch: (String) -> Unit = {},
    onNavigateToDetail: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        HomeHeader(query = query, onSearch = onSearch)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(PokeAppTheme.dimens.space8)
        ) {
            items(list) {
                PokemonItem(
                    modifier = Modifier.padding(PokeAppTheme.dimens.space8),
                    name = it.name,
                    imageUrl = it.imageUrl,
                    types = it.types,
                    onItemClick = onNavigateToDetail
                )
            }
        }
    }
}

@Composable
private fun HomeHeader(
    modifier: Modifier = Modifier,
    query: String,
    onSearch: (String) -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
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
                .padding(PokeAppTheme.dimens.space16),
            query = query,
            onQueryChange = onSearch
        )

    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    PokeAppTheme {
        HomeScreen(list = emptyList())
    }
}