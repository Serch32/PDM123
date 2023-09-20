package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R

class CartasViewModel: ViewModel() {
    var getRandomImage = MutableLiveData(R.drawable.back)
    fun getRandomElement(): MutableLiveData<Int> = getRandomImage
    fun randomNumber(){
        when ((0..12).random()) { // generated random from 0 to 10 included
            0 -> getRandomImage.postValue(R.drawable.h01)
            1 -> getRandomImage.postValue(R.drawable.h02)
            2 -> getRandomImage.postValue(R.drawable.h03)
            3 -> getRandomImage.postValue(R.drawable.h04)
            4 -> getRandomImage.postValue(R.drawable.h05)
            5 -> getRandomImage.postValue(R.drawable.h06)
            6 -> getRandomImage.postValue(R.drawable.h07)
            7 -> getRandomImage.postValue(R.drawable.h08)
            8 -> getRandomImage.postValue(R.drawable.h09)
            9 -> getRandomImage.postValue(R.drawable.h10)
            10-> getRandomImage.postValue(R.drawable.hc1j)
            11 -> getRandomImage.postValue(R.drawable.hc2q)
            12 -> getRandomImage.postValue(R.drawable.k)

        }
    }
    fun getBackCards(){
        getRandomImage.postValue(R.drawable.back)
    }
}