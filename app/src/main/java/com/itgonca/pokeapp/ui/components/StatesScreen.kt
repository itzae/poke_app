package com.itgonca.pokeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itgonca.pokeapp.R
import com.itgonca.pokeapp.ui.theme.PokeAppTheme

@Composable
fun ErrorScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(R.drawable.il_page_lost),
                contentDescription = "Image for error"
            )
            Text(
                text = stringResource(R.string.error_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = stringResource(R.string.error_description),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(modifier = Modifier.padding(PokeAppTheme.dimens.space16))
            Text(
                text = stringResource(R.string.loading_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = stringResource(R.string.loading_description),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    PokeAppTheme {
        LoadingScreen()
    }
}