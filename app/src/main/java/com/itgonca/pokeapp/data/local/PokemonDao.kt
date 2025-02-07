package com.itgonca.pokeapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAllPokemons(): Flow<List<PokemonEntity>?>

    @Query("SELECT * FROM pokemon WHERE name LIKE '%' || :pokemonId || '%'")
    fun getPokemonById(pokemonId: String): Flow<PokemonEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(pokemon: PokemonEntity)
}