package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun CartasView(navController: NavController, viewModel: CartasViewModel) {
    val carta by viewModel.getRandomElement().observeAsState(R.drawable.back)


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = carta), contentDescription ="Iamgen", modifier = Modifier.height(450.dp).width(450.dp) )
        Row{
            Button(onClick = {
                viewModel.getBackCards()
            }, modifier = Modifier.padding(8.dp)){
                Text(text = "Esconder Carta")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick ={ viewModel.randomNumber()}) {
                Text(text = "Obtener Carta")
            }

        }


    }

}