package com.example.pdm123.firstpartial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun NumMView(navController: NavController, viewModel: NumMViewModel) {
    var txtNumber by remember { mutableStateOf("") }
    var txtNumber2 by remember { mutableStateOf("") }
    var txtNumber3 by remember { mutableStateOf("") }
    val minorNumber by viewModel.getResultStatus().observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Determinar cual es menor")
        TextField(
            value = txtNumber,
            onValueChange = {
                txtNumber = it

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = txtNumber2,
            onValueChange = {
                txtNumber2 = it

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = txtNumber3,
            onValueChange = {
                txtNumber3 = it

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            viewModel.isMinor(txtNumber.toInt(), txtNumber2.toInt(), txtNumber3.toInt())
        }) {
            Text(text = "Calcular")
        }

        Text(text = minorNumber)


    }

}