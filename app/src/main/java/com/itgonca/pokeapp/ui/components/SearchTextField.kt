package com.itgonca.pokeapp.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    query: String,
    placeholder: String = "",
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        placeholder = { Text(text = placeholder) },
        value = query,
        onValueChange = onQueryChange,
        shape = CircleShape,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    PokeAppTheme {
        SearchTextField(query = "", placeholder = "Busca un pokemon") { }
    }
}