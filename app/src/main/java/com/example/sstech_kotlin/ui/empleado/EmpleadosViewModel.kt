package com.example.sstech_kotlin.ui.empleado

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmpleadosViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Empleados"
    }
    val text: LiveData<String> = _text
}