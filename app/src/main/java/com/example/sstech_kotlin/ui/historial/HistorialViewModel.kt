package com.example.sstech_kotlin.ui.historial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistorialViewModel : ViewModel() {

    private val _historial = MutableLiveData<List<String>>().apply {
        value = listOf() // Inicialmente vacío
    }
    val historial: LiveData<List<String>> = _historial

    // Método para agregar un pedido al historial
    fun agregarPedido(pedido: String) {
        _historial.value = _historial.value?.plus(pedido)
    }
}
