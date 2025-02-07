package com.itgonca.pokeapp.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itgonca.pokeapp.data.local.PokemonEntity

class StatListConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromStatEntityList(value: List<PokemonEntity.StatEntity>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStatEntityList(value: String?): List<PokemonEntity.StatEntity>? {
        if (value == null) return emptyList()
        val listType = object : TypeToken<List<PokemonEntity.StatEntity>>() {}.type
        return gson.fromJson(value, listType)
    }
}