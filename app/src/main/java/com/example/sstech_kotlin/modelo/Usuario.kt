package com.example.sstech_kotlin.modelo

open class Usuario
    (
    var correo: String,
    var contrasena: String,
    var nombre: String = "",
    var apellido: String = "",
    var telefono: String = "",
    var direccion: String = ""
)