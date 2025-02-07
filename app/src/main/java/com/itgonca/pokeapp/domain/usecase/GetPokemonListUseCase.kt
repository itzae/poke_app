package com.itgonca.pokeapp.domain.usecase

import com.itgonca.pokeapp.domain.model.Pokemon
import com.itgonca.pokeapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    operator fun invoke() = flow {
        val pokemonList = pokemonRepository.getPokemonsList().map {
            val result = pokemonRepository.getPokemonDetail(it.name)
            Pokemon(name = result.name, imageUrl = result.imageUrl, types = result.types)
        }
        emit(pokemonList)
    }
}