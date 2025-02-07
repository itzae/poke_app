package com.itgonca.pokeapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val pokemons: List<Pokemon>
){
     data class Pokemon(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}