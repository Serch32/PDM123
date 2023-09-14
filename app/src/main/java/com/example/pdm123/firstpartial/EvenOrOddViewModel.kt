package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EvenOrOddViewModel: ViewModel() {
    var evenOrOddStatus = MutableLiveData<String>()
    var yesOrno = MutableLiveData<Boolean>()





     fun getimage(): MutableLiveData<Boolean> = yesOrno
    fun getResultStatus(): MutableLiveData<String> = evenOrOddStatus
    fun isEven(number: Int) {
        if (number != 0){
            if (number % 2 == 0) {
                evenOrOddStatus.postValue("El numero es par")
               yesOrno.postValue(false)
            }else{
                evenOrOddStatus.postValue("El numero es non")
                yesOrno.postValue(true)
            }
        }else{
            evenOrOddStatus.postValue("El numero es indeterminado")
        }

    }
}