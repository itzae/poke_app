package com.itgonca.pokeapp.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import com.itgonca.pokeapp.ui.PokemonState
import com.itgonca.pokeapp.ui.toDetailUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val _detailState = MutableStateFlow(PokemonState())
    val detailState: StateFlow<PokemonState>
        get() = _detailState.asStateFlow()

    fun getDetail(id: String) {
        viewModelScope.launch {
            val response = pokemonRepository.getPokemonDetail(id)
            _detailState.update { response.toDetailUi() }
        }
    }
}