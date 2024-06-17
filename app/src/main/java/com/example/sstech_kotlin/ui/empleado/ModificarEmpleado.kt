package com.example.sstech_kotlin.ui.empleado


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Empleado

class ModificarEmpleado : AppCompatActivity() {

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
        setContentView(R.layout.activity_modificar_empleado)
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
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnConsultarEmpleado -> consultar()
            R.id.btnModificarEmpleado -> modificar()
            R.id.btnRegresar -> regresar()
        }
    }

    private fun consultar() {
        if (correo.text.toString().isNotEmpty()) {
            val empleadoConsultado = Empleado.encontrarEmpleado(correo.text.toString())

            if (empleadoConsultado != null) {
                println(empleadoConsultado.telefono)
                nombre.setText(empleadoConsultado.nombre)
                apellido.setText(empleadoConsultado.apellido)
                telefono.setText(empleadoConsultado.telefono)

                // Set spinner values
                val puestoPosition = (puesto.adapter as ArrayAdapter<String>).getPosition(empleadoConsultado.puesto)
                puesto.setSelection(puestoPosition)

                especialidad.setText(empleadoConsultado.especialidad)

                val horarioPosition = (horario.adapter as ArrayAdapter<String>).getPosition(empleadoConsultado.horario)
                horario.setSelection(horarioPosition)

                fechaContratacion.setText(empleadoConsultado.fechaContratacion)
                salario.setText(empleadoConsultado.salario)

                Toast.makeText(this, "Empleado consultado exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El empleado con el correo especificado no existe", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Complete el campo de correo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun modificar() {
        if (correo.text.toString().isNotEmpty() && camposCompletos()) {
            val empleadoConsultado = Empleado.encontrarEmpleado(correo.text.toString())

            if (empleadoConsultado != null) {
                empleadoConsultado.actualizar(
                    nombre.text.toString(),
                    apellido.text.toString(),
                    telefono.text.toString(),
                    puesto.selectedItem.toString(),
                    especialidad.text.toString(),
                    horario.selectedItem.toString(),
                    fechaContratacion.text.toString(),
                    salario.text.toString()
                )

                Toast.makeText(this, "Empleado modificado exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El empleado con el correo especificado no existe", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun regresar() {
        finish()
    }

    private fun camposCompletos(): Boolean {
        return nombre.text.isNotEmpty() && apellido.text.isNotEmpty() && telefono.text.isNotEmpty()
                && especialidad.text.isNotEmpty() && fechaContratacion.text.isNotEmpty()
                && salario.text.isNotEmpty()
    }
}