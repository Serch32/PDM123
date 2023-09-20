package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumMViewModel: ViewModel() {
    var minorNumber = MutableLiveData<String>()
    fun getResultStatus(): MutableLiveData<String> = minorNumber

    fun isMinor(number: Int,number2:Int,number3:Int) {
        if (number < number2 && number <number3){
            minorNumber.postValue("El numero menor es $number")
        }else if (number2 <number && number2 <number3) {
            minorNumber.postValue("El numero menor es $number2")
        }else  {
            minorNumber.postValue("El numero menor es $number3")
        }

        }

    }
