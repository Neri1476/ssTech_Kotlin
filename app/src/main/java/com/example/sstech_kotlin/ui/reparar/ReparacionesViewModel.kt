package com.example.sstech_kotlin.ui.reparar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReparacionesViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Reparaciones"
    }
    val text: LiveData<String> = _text
}