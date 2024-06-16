package com.example.sstech_kotlin.modelo

class Empleado : Usuario {
    var puesto: String
    var especialidad: String
    var horario: String
    var fechaContratacion: String
    var salario: String

    constructor(
        correo: String,
        nombre: String,
        apellido: String,
        telefono: String,
        puesto: String,
        especialidad: String,
        horario: String,
        fechaContratacion: String,
        salario: String
    ) : super(correo, nombre, apellido, telefono) {
        this.puesto = puesto
        this.especialidad = especialidad
        this.horario = horario
        this.fechaContratacion = fechaContratacion
        this.salario = salario
    }

    fun actualizar(
        nombre: String,
        apellido: String,
        telefono: String,
        puesto: String,
        especialidad: String,
        horario: String,
        salario: String
    ) {
        this.nombre = nombre
        this.apellido = apellido
        this.telefono = telefono
        this.puesto = puesto
        this.especialidad = especialidad
        this.horario = horario
        this.salario = salario
    }

    companion object {
        val listaEmpleados = mutableListOf<Empleado>()

        fun agregarEmpleado(empleado: Empleado) {
            Empleado.listaEmpleados.add(empleado)
        }

        fun encontrarEmpleado(correo: String): Empleado? {
            return listaEmpleados.find { it.correo == correo }
        }

        fun obtenerTodosTecnicos(): List<Empleado> {
            return Empleado.listaEmpleados
        }
    }
}