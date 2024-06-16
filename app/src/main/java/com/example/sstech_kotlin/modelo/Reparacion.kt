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

    // Guarda reparación en una lista (cada cliente debe tener su propio historial)
    companion object
    {
        val listaReparaciones = mutableListOf<Reparacion>()

        fun agregarPedido(reparacion: Reparacion)
        {
            listaReparaciones.add(reparacion)
        }

        fun logitudReparacion() : Int
        {
            return Reparacion.listaReparaciones.size
        }

        fun mostrarReparacionCliente(context: Context, correo: String) : List<Reparacion>
        {
            val reparacionesCliente = listaReparaciones.filter { it.correo_Cliente == correo }
            if (reparacionesCliente.isEmpty())
            {
                Toast.makeText(context, "No hay reparaciones para este cliente", Toast.LENGTH_LONG).show()
            }
            return reparacionesCliente
        }
    }
}