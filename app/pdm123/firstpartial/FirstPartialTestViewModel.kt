package com.example.pdm123.firstpartial

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ApplesViewModel : ViewModel() {
    val currentTP = mutableStateOf(0)
    val currentAP = mutableStateOf(0)
    val percentage = mutableStateOf(0f)

    val totalProduction: State<Int> = currentTP
    val actualProduction: State<Int> = currentAP

    val uiState = mutableStateOf<UIState>(UIState.Idle)

    fun add5() = performAddOperation(5)
    fun add15() = performAddOperation(15)
    fun add30() = performAddOperation(30)
    fun add50() = performAddOperation(50)

    fun calculatePercentage(total: Int, actual: Int) {
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.CalculatingPercentage
            if (total != 0) {
                val calculatedPercentage = (actual.toFloat() / total.toFloat()) * 100
                percentage.value = calculatedPercentage
                println("Calculated Percentage: $calculatedPercentage")
            }
            uiState.value = UIState.Idle
        }
    }

    fun calculateTotalProdToast(context: Context) {
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.CalculatingTotalProdToast
            val total = currentTP.value
            val result = total * 80
            val toastMessage = "$result manzanas"
            showToast(context, toastMessage)
            uiState.value = UIState.Idle
        }
    }

    fun calculateActualProdToast(context: Context) {
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.CalculatingActualProdToast
            val actual = currentAP.value
            val result = actual * 80
            val toastMessage = "$result manzanas"
            showToast(context, toastMessage)
            uiState.value = UIState.Idle
        }
    }

    private fun performAddOperation(amount: Int) {
        if (uiState.value == UIState.Idle) {
            uiState.value = when (amount) {
                5 -> UIState.Adding5
                15 -> UIState.Adding15
                30 -> UIState.Adding30
                50 -> UIState.Adding50
                else -> UIState.Idle
            }
            currentAP.value += amount
            calculatePercentage(currentTP.value, currentAP.value)
            uiState.value = UIState.Idle
        }
    }

    private fun showToast(context: Context, message: String) {
        val toastMessage = "$message manzanas"
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }
}

sealed class UIState {
    object Idle : UIState()
    object Adding5 : UIState()
    object Adding15 : UIState()
    object Adding30 : UIState()
    object Adding50 : UIState()
    object CalculatingPercentage : UIState()
    object CalculatingTotalProdToast : UIState()
    object CalculatingActualProdToast : UIState()
}
