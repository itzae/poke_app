package com.itgonca.pokeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itgonca.pokeapp.data.local.converters.StatListConverters
import com.itgonca.pokeapp.data.local.converters.StringListConverter

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(StringListConverter::class, StatListConverters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}