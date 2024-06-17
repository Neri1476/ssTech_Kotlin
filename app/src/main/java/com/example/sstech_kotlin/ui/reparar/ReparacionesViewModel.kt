package com.example.sstech_kotlin.ui.reparar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sstech_kotlin.modelo.Empleado

class ReparacionesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Reparaciones"
    }
    val text: LiveData<String> = _text
}
