package com.example.sstech_kotlin.ui.cita

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrarCitaModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Registrar cita"
    }
    val text: LiveData<String> = _text
}