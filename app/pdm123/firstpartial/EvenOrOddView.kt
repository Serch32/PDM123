package com.example.pdm123.firstpartial

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R

import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationNon
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationPar

@Composable
fun EvenOrOddView(navController: NavController, viewModel: EvenOrOddViewModel) {
    var txtNumber by remember { mutableStateOf("") }
    val evenOrOddStatus by viewModel.getResultStatus().observeAsState("")


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {




                if (viewModel.getimage().value==false) {
        ComposeLottieAnimationPar(modifier = Modifier.width(250.dp).height(250.dp))

                }else{
                    ComposeLottieAnimationNon(modifier = Modifier.width(250.dp).height(250.dp))
                }



        Text(text = "Determinar que es")
        TextField(
            value = txtNumber,
            onValueChange = {
                txtNumber = it
                if (txtNumber != "") {
                    viewModel.isEven(txtNumber.toInt())
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = evenOrOddStatus)


    }

}