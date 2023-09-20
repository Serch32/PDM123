package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun BarberView(navController: NavController, viewModel: BarberViewModel) {
    val barbaCountResult by viewModel.getBarbaCount().observeAsState(0)
    val peloCountResult by viewModel.getPeloCount().observeAsState(0)
    val peloBarbaCountResult by viewModel.getPeloBarbaCount().observeAsState(0)
    val totalCostResult by viewModel.getTotalCost().observeAsState(0)


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Row {

            //Se agregan los textos con sus respectivas variables
            Text(text = "$350")

            Spacer(modifier = Modifier.width(125.dp))


            Text(text = "$450")


            Spacer(modifier = Modifier.width(125.dp))

            Text(text = "$900g")


        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            //Boton con imagen de barba
            Button(onClick = {
                viewModel.incrementBarba()

            }, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.barba),
                    contentDescription = "barba",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
            }
            //Boton con imagen de corte
            Button(onClick = {
                viewModel.incrementPelo()
            }, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.corte),
                    contentDescription = "corte",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
            }
            //Boton con imagen de corte y barba
            Button(onClick = {
                viewModel.incrementPeloBarba()
            }, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.corteybarba),
                    contentDescription = "corte y barba",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
            }


        }
        Row {

            //Se agregan los textos con sus respectivas variables
            Text(text = "${peloCountResult}")

            Spacer(modifier = Modifier.width(125.dp))


            Text(text = "${barbaCountResult}")


            Spacer(modifier = Modifier.width(125.dp))

            Text(text = "${peloBarbaCountResult}")


        }
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Text(text = "Total: $$totalCostResult")
        }
    }
}