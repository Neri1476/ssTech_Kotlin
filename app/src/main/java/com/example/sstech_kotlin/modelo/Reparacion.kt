package com.example.sstech_kotlin.modelo

import android.content.Context
import android.widget.Toast
import java.util.Date

class Reparacion
{
    var idR: String = ""
    var correo_Cliente: String = "" //
    var correo_Empleado: String = "" //
    var falla: String = "" //
    var plazo_Entrega: Date = Date() //
    var estado: Boolean = false //Esta madre la hace el admin

    constructor(
        id: String,
        cliente: String,
        empleado: String,
        falla: String,
        plazo: Date,
        estado: Boolean
    )
    {
        this.idR = id
        this.correo_Cliente = cliente
        this.correo_Empleado = empleado
        this.falla = falla
        this.plazo_Entrega = plazo
        this.estado = estado
    }

    fun definirPlazo(nuevoPlazo: Date)
    {
        this.plazo_Entrega = nuevoPlazo
    }

    fun actualizarEstado(nuevoEstado: Boolean)
    {
        this.estado = nuevoEstado
    }

    fun asignarEmpleado(nuevoEmpleado: String)
    {
        this.correo_Empleado = nuevoEmpleado
    }

    fun obtenerEstadoComoTexto(): String
    {
        return if (estado) "Terminado" else "En proceso"
    }

    // Guarda reparación en una lista (cada cliente debe tener su propio historial)
    companion object
    {
        val listaReparaciones = mutableListOf<Reparacion>()

        fun agregarPedido(reparacion: Reparacion)
        {
            listaReparaciones.add(reparacion)
        }

        fun longitudReparacion() : Int
        {
            return Reparacion.listaReparaciones.size
        }

        fun mostrarReparacionCliente(context: Context, correo: String): List<Reparacion> {
            val reparacionesCliente = listaReparaciones.filter { it.correo_Cliente == correo }
            if (reparacionesCliente.isEmpty()) {
                Toast.makeText(context, "No hay reparaciones para este cliente", Toast.LENGTH_LONG).show()
            }
            return reparacionesCliente
        }


        fun buscarReparacionesPorId(id: String): Reparacion?
        {
            return Reparacion.listaReparaciones.find { it.idR.equals(id) }
        }

        fun obtenerTodosReparaciones(): List<Reparacion>
        {
            return Reparacion.listaReparaciones
        }

        fun cambiarEstadoAtrue(id: String): Boolean {
            val reparacion = buscarReparacionesPorId(id)
            return if (reparacion != null) {
                reparacion.estado = true
                true
            } else {
                false
            }
        }
    }
}