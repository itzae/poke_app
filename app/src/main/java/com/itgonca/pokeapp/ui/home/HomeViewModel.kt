package com.itgonca.pokeapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import com.itgonca.pokeapp.domain.usecase.GetPokemonListUseCase
import com.itgonca.pokeapp.ui.toPokemonItemUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPokemonListUseCase: GetPokemonListUseCase,
) : ViewModel() {
    val pokemonList = getPokemonListUseCase()
        .map { pokemonList ->
            pokemonList.map { it.toPokemonItemUi() }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
}