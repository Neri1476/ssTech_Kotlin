package com.example.sstech_kotlin.ui.componente

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComponentesViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Componentes"
    }
    val text: LiveData<String> = _text
}