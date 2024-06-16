package com.example.sstech_kotlin.modelo

import java.util.Date

class Reparacion
{
    var idR: Int = 0
    var correo_Cliente: String = ""
    var correo_Empleado: String = ""
    var falla: String = ""
    var plazo_Entrega: Date = TODO()
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

    // Guarda clientes en una lista
    companion object
    {
        val listaReparaciones = mutableListOf<Reparacion>()

        fun agregarPedido(reparacion: Reparacion)
        {
            listaReparaciones.add(reparacion)
        }

        fun mostrarInformacionCliente(correo: String)
        {

        }
    }
}