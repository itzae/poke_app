package com.itgonca.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.itgonca.pokeapp.ui.home.HomeScreen
import com.itgonca.pokeapp.ui.home.HomeViewModel
import com.itgonca.pokeapp.ui.theme.PokeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeAppTheme {
                val viewmodel: HomeViewModel = hiltViewModel()
                val list by viewmodel.pokemonList.collectAsStateWithLifecycle()
                HomeScreen(list = list)
            }
        }
    }
}
