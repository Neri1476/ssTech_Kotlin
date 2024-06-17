package com.example.sstech_kotlin.ui.empleado

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Empleado

class RegistrarEmpleado : AppCompatActivity() {

    private lateinit var correo: EditText
    private lateinit var nombre: EditText
    private lateinit var apellido: EditText
    private lateinit var telefono: EditText
    private lateinit var puesto: Spinner
    private lateinit var especialidad: EditText
    private lateinit var horario: Spinner
    private lateinit var fechaContratacion: EditText
    private lateinit var salario: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_empleado)
        supportActionBar?.hide()

        correo = findViewById(R.id.txtCorreoEmpleado)
        nombre = findViewById(R.id.txtNombreEmpleado)
        apellido = findViewById(R.id.txtApellidoEmpleado)
        telefono = findViewById(R.id.txtTelEmpleado)
        puesto = findViewById(R.id.spinnerPuestoEmpleado)
        especialidad = findViewById(R.id.txtEspEmpleado)
        horario = findViewById(R.id.spinnerHorarioEmpleado)
        fechaContratacion = findViewById(R.id.txtContratacionEmpleado)
        salario = findViewById(R.id.txtSalarioEmpleado)

        // Set up the spinners
        ArrayAdapter.createFromResource(
            this,
            R.array.puesto_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            puesto.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.horario_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            horario.adapter = adapter
        }

        findViewById<ImageButton>(R.id.btnRegistrar).setOnClickListener { registrar() }
        findViewById<ImageButton>(R.id.btnRegresar).setOnClickListener { finish() }
    }

    private fun registrar() {
        if (camposCompletos()) {
            val nuevoEmpleado = Empleado(
                correo.text.toString(),
                nombre.text.toString(),
                apellido.text.toString(),
                telefono.text.toString(),
                puesto.selectedItem.toString(),
                especialidad.text.toString(),
                horario.selectedItem.toString(),
                fechaContratacion.text.toString(),
                salario.text.toString()
            )
            Empleado.agregarEmpleado(nuevoEmpleado)
            Toast.makeText(
                this, "Empleado registrado con éxito", Toast.LENGTH_SHORT
            ).show()
            finish()
        } else {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun camposCompletos(): Boolean {
        return correo.text.isNotEmpty() && nombre.text.isNotEmpty() && apellido.text.isNotEmpty()
                && telefono.text.isNotEmpty() && especialidad.text.isNotEmpty()
                && fechaContratacion.text.isNotEmpty() && salario.text.isNotEmpty()
    }
}