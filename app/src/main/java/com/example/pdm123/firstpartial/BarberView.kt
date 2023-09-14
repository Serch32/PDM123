package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun BarberView(navController: NavController, viewModel: BarberViewModel){
    var price by remember { mutableStateOf("") }
 Column() {


     Row(
         modifier = Modifier
             .height(450.dp)
             .width(400.dp)
     ) {
         Spacer(modifier = Modifier.width(25.dp))
         Column(
             horizontalAlignment = Alignment.Start,
             verticalArrangement = Arrangement.Center
         ) {
             Text(text = "Barba")
             Button(onClick = { /*TODO*/ }) {

                 Image(
                     painter = painterResource(R.drawable.barba),
                     contentDescription = "Imagen",
                     modifier = Modifier
                         .height(70.dp)
                         .width(70.dp)
                 )

             }
             Text(text = "$300")
         }
         Spacer(modifier = Modifier.width(25.dp))
         Column(

             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center


         ) {
             Text(text = "Corte")
             Button(onClick = { /*TODO*/ }) {

                 Image(
                     painter = painterResource(R.drawable.corte),
                     contentDescription = "Imagen",
                     modifier = Modifier
                         .height(70.dp)
                         .width(70.dp)
                 )

             }
             Text(text = "$200")
         }
         Spacer(modifier = Modifier.width(25.dp))
         Column(

             horizontalAlignment = Alignment.End,
             verticalArrangement = Arrangement.Center


         ) {
             Text(text = "Barba Y Corte")
             Button(onClick = { /*TODO*/ }) {

                 Image(
                     painter = painterResource(R.drawable.corteybarba),
                     contentDescription = "Imagen",
                     modifier = Modifier
                         .height(70.dp)
                         .width(70.dp)
                 )

             }
             Text(text = "$500")
         }
     }
     Column() {
         Text(text = "Total")
     }
 }



}