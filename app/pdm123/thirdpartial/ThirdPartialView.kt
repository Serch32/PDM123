package com.example.pdm123.thirdpartial


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pdm123.R

@Composable
fun ThirdPartialView() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.third_partial),
            color = MaterialTheme.colors.secondary
        )

    }
}