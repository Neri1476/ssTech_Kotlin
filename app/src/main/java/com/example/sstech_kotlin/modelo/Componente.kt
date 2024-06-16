package com.example.sstech_kotlin.modelo

class Componente {
    var id: Int = 0
    var nombre: String = ""
    var cantidad: String = ""
    var precio: String = ""
    var provedor: String = ""

    constructor(id: Int,
                nombre: String,
                cantidad: String,
                precio: String,
                provedor: String) {
        this.id = id
        this.nombre = nombre
        this.cantidad = cantidad
        this.precio = precio
        this.provedor = provedor
    }

    companion object {
        val listaComponentes = mutableListOf<Componente>()

        fun logitudComponente() : Int {
            return listaComponentes.size
        }
        fun agregarComponente(componente: Componente) {
            listaComponentes.add(componente)
        }

        fun modificarComponente(id: Int, nuevoNombre: String, nuevaCantidad: String, nuevoPrecio: String, nuevoProveedor: String): Componente? {
            val componente = buscarComponentePorId(id)
            if (componente != null) {
                componente.nombre = nuevoNombre
                componente.cantidad = nuevaCantidad
                componente.precio = nuevoPrecio
                componente.provedor = nuevoProveedor
                return componente
            } else {
                return null
            }
        }

        fun buscarComponentePorId(id: Int): Componente? {
            return listaComponentes.find { it.id == id }
        }

        fun obtenerTodosComponentes(): List<Componente> {
            return listaComponentes
        }
    }
}