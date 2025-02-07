package com.itgonca.pokeapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.query
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import com.itgonca.pokeapp.domain.usecase.GetPokemonListUseCase
import com.itgonca.pokeapp.ui.PokemonState
import com.itgonca.pokeapp.ui.toPokemonItemUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Thread.State
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonState>>(emptyList())
    val pokemonList: StateFlow<List<PokemonState>>
        get() = _pokemonList.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    /*val fetchPokemons = getPokemonListUseCase().map { response ->
        _pokemonList.update {
            response.map {
                it.toPokemonItemUi()
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = PokemonState()
    )*/

    val searchList = _searchQuery
        .debounce(500)
        .distinctUntilChanged()
        .flatMapLatest { query ->
            if (query.isEmpty()) {
                getPokemonListUseCase().map { response-> response.map { it.toPokemonItemUi() } }
            } else {
                pokemonRepository.searchPokemon(query)
                    .map { response ->
                        response.map { it.toPokemonItemUi() }
                    }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun searchPokemon(pokemoId: String) {
        _searchQuery.update { pokemoId }
    }
}