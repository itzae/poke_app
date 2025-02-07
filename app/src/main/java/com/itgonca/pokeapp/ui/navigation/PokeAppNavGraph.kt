package com.itgonca.pokeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.itgonca.pokeapp.ui.detail.DetailScreen
import com.itgonca.pokeapp.ui.detail.DetailViewModel
import com.itgonca.pokeapp.ui.home.HomeScreen
import com.itgonca.pokeapp.ui.home.HomeViewModel

const val POKEMON_ID = "pokemon_id"

@Composable
fun PokeAppNavGraph(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    NavHost(navController = navHostController, startDestination = PokeAppScreenRoutes.HomeScreen) {
        composable<PokeAppScreenRoutes.HomeScreen> {
            val pokemonList by viewModel.pokemonList.collectAsStateWithLifecycle()
            HomeScreen(
                list = pokemonList,
                onNavigateToDetail = {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set(POKEMON_ID, it)
                    navHostController.navigate(PokeAppScreenRoutes.DetailScreen)


                })
        }
        composable<PokeAppScreenRoutes.DetailScreen> {
            val detailViewModel: DetailViewModel = hiltViewModel()
            val id =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<String>(POKEMON_ID)
            LaunchedEffect(Unit) {
                detailViewModel.getDetail(id ?: "")
            }
            val state by detailViewModel.detailState.collectAsStateWithLifecycle()
            DetailScreen(pokemonState = state) { navHostController.navigateUp() }
        }
    }
}