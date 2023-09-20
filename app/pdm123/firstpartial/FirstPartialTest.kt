package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pdm123.R
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController


@Composable
fun ApplesView(navController: NavController, viewModel: ApplesViewModel) {
    val totalProdRes by viewModel.totalProduction
    val actualProdRes by viewModel.actualProduction
    val percentageRes by viewModel.percentage
    val context = LocalContext.current

    // Color de fondo inicial (por ejemplo, gris claro)
    val backgroundColor = if (percentageRes >= 70f) Color.Red else Color.LightGray

    var totalProdTxt by remember { mutableStateOf(totalProdRes.toString()) }
    var actualProdTxt by remember { mutableStateOf(actualProdRes.toString()) }
    var percentageTxt by remember { mutableStateOf("0.0") }

    Column(
        modifier = Modifier.fillMaxSize().background(backgroundColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.manzanas),
                contentDescription = "Manzanas"
            )

            Spacer(
                modifier = Modifier
                    .width(9.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Produccion Total",
                modifier = Modifier.padding(15.dp)
            )

            TextField(
                value = viewModel.currentTP.value.toString(),
                onValueChange = { viewModel.currentTP.value = it.toIntOrNull() ?:0 },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(100.dp).height(49.dp)
            )

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.manzana),
                contentDescription = "Manzana",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        viewModel.calculateTotalProdToast(context)
                    }
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Produccion Actual",
                modifier = Modifier.padding(15.dp)
            )

            TextField(
                value = viewModel.currentAP.value.toString(),
                onValueChange = {
                    viewModel.currentAP.value = it.toIntOrNull() ?: 0
                },
                modifier = Modifier.width(100.dp).height(49.dp),
                enabled = false
            )

            Spacer(
                modifier = Modifier.width(50.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.manzana),
                contentDescription = "Manzana",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        viewModel.calculateActualProdToast(context)
                    }
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.add5() },
            ) {
                Text(text = "+5")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add15() }) {
                Text(text = "+15")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add30() }) {
                Text(text = "+30")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add50() }) {
                Text(text = "+50")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Porcentaje",
                modifier = Modifier.padding(15.dp)
            )

            Text("$percentageRes")
        }

        // Botón para calcular el porcentaje
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.calculatePercentage(totalProdRes, actualProdRes) },
            ) {
                Text(text = "Calcular")
            }
        }
    }
}
