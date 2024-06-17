package com.example.sstech_kotlin.ui.reparar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sstech_kotlin.modelo.Empleado

data class Reparacion(val descripcion: String, var estado: String, var tecnico: Empleado?)

class ReparacionesViewModel : ViewModel() {

    private val _reparaciones = MutableLiveData<List<Reparacion>>().apply {
        value = emptyList()
    }
    val reparaciones: LiveData<List<Reparacion>> = _reparaciones

    fun agregarReparacion(reparacion: Reparacion) {
        val listaActual = _reparaciones.value.orEmpty().toMutableList()
        listaActual.add(reparacion)
        _reparaciones.value = listaActual.toList()
    }

    fun cambiarEstadoReparacion(index: Int, nuevoEstado: String) {
        val listaActual = _reparaciones.value.orEmpty().toMutableList()
        if (index in listaActual.indices) {
            listaActual[index] = listaActual[index].copy(estado = nuevoEstado)
            _reparaciones.value = listaActual.toList()
        }
    }
}
