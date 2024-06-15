package com.example.sstech_kotlin.modelo

import java.util.Date

class Cliente : Usuario {
    var fechaRegistro: String
    var historialReparaciones: List<String>
    var preferencias: String
    var dispositivosRegistrados: List<String>
    var feedback: String

    // Creacion de cliente
    constructor(
        correo: String,
        contrasena: String,
        nombre: String,
        apellido: String,
        telefono: String,
        direccion: String,
        fechaRegistro: String
    ) : super(correo, contrasena, nombre, apellido, telefono, direccion) {
        this.fechaRegistro = fechaRegistro
        this.historialReparaciones = listOf() // Inicializar con lista vacía o valor por defecto
        this.preferencias = ""
        this.dispositivosRegistrados = listOf() // Inicializar con lista vacía o valor por defecto
        this.feedback = ""
    }

    fun actualizar(
        nombre: String,
        apellido: String,
        telefono: String,
        direccion: String,
        preferencias: String,
        feedback: String
    ) {
        this.nombre = nombre
        this.apellido = apellido
        this.telefono = telefono
        this.direccion = direccion
        this.preferencias = preferencias
        this.feedback = feedback
        this.preferencias = preferencias
        this.feedback = feedback
    }

    // Guarda clientes en una lista
    companion object {
        val listaClientes = mutableListOf<Cliente>()

        fun agregarCliente(cliente: Cliente) {
            listaClientes.add(cliente)
        }

        fun login(correo: String, contrasena: String): Cliente? {
            return listaClientes.find { it.correo == correo && it.contrasena == contrasena }
        }

        fun mostrarInformacionCliente(correo: String) {
            val clienteEncontrado = listaClientes.find { it.correo == correo }
            if (clienteEncontrado != null) {
                println(clienteEncontrado)
            } else {
                println("Cliente no encontrado.")
            }
        }

        fun actualizarCliente(
            correo: String,
            nombre: String,
            apellido: String,
            telefono: String,
            direccion: String,
            preferencias: String,
            feedback: String
        ) {
            val clienteEncontrado = listaClientes.find { it.correo == correo }
            clienteEncontrado?.actualizar(nombre, apellido, telefono, direccion, preferencias, feedback)
        }
    }
}