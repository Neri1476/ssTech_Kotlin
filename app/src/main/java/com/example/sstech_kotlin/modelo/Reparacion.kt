package com.example.sstech_kotlin.modelo

import android.content.Context
import android.widget.Toast
import java.util.Date

class Reparacion
{
    var idR: Int = 0
    var correo_Cliente: String = ""
    var correo_Empleado: String = ""
    var falla: String = ""
    var plazo_Entrega: Date = Date()
    var costo: Double = 0.0
    var estado: Boolean = false

    constructor(id: Int, cliente: String, empleado: String, falla: String, plazo: Date, costo: Double, estado: Boolean)
    {
        this.idR = id
        this.correo_Cliente = cliente
        this.correo_Empleado = empleado
        this.falla = falla
        this.plazo_Entrega = plazo
        this.costo = costo
        this.estado = estado
    }

    fun actualizarEstado()
    {

    }

    // Guarda reparación en una lista (cada cliente debe tener su propio historial)
    companion object
    {
        val listaReparaciones = mutableListOf<Reparacion>()

        fun agregarPedido(reparacion: Reparacion)
        {
            listaReparaciones.add(reparacion)
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