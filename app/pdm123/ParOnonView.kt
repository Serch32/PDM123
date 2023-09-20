package com.example.pdm123

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun ParOnonView(navController: NavController) {
    var txtNumber by remember { mutableStateOf("") }

    Column {
        Text(text = "Par o non")


        Text(text = stringResource(id = R.string.even_or_odd))

    }

}