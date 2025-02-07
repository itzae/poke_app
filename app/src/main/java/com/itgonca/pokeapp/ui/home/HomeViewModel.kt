package com.itgonca.pokeapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import com.itgonca.pokeapp.domain.usecase.GetPokemonListUseCase
import com.itgonca.pokeapp.ui.PokemonState
import com.itgonca.pokeapp.ui.toPokemonItemUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _homeState = MutableStateFlow<PokemonState>(PokemonState.Loading)
    val homeState: StateFlow<PokemonState>
        get() = _homeState.asStateFlow()

    val searchList = _searchQuery
        .onStart { _homeState.update { PokemonState.Loading } }
        .debounce(500)
        .distinctUntilChanged()
        .flatMapLatest { query ->

            if (query.isEmpty()) {
                getPokemonListUseCase().map { response ->
                    val result = response.map { it.toPokemonItemUi() }
                    _homeState.update { PokemonState.Success(result) }
                    result
                }
            } else {
                pokemonRepository.searchPokemon(query)
                    .map { response ->
                        val result = response.map { it.toPokemonItemUi() }
                        _homeState.update { PokemonState.Success(result) }
                        result
                    }
            }

        }.catch {
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun searchPokemon(pokemonId: String) {
        _searchQuery.update { pokemonId }
    }
}