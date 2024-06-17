package com.example.sstech_kotlin.ui.reparar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Reparacion(val descripcion: String, var estado: String)

class ReparacionesViewModel : ViewModel() {
    private val _reparaciones = MutableLiveData<List<Reparacion>>().apply {
        value = listOf(
            Reparacion("Reparación de pantalla", "En proceso"),
            Reparacion("Cambio de batería", "Pendiente"),
            Reparacion("Reparación de teclado", "Finalizado")
        )
    }
    val reparaciones: LiveData<List<Reparacion>> = _reparaciones

    // Método para cambiar el estado de la reparación
    fun cambiarEstadoReparacion() {
        _reparaciones.value = _reparaciones.value?.map { reparacion ->
            if (reparacion.estado == "En proceso") {
                reparacion.copy(estado = "Finalizado")
            } else {
                reparacion
            }
        }
    }
}
