package com.example.sstech_kotlin.ui.reparar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Componente
import com.example.sstech_kotlin.modelo.Reparacion
import com.google.android.material.chip.Chip

class BuscarReparacion : AppCompatActivity() {

    private lateinit var id: EditText
    private lateinit var reparacionResultado: TextView
    private lateinit var chipCambiarEstado: Chip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_reparacion)
        supportActionBar?.hide()

        id = findViewById(R.id.txtCorreoClienteReparaciones)
        reparacionResultado = findViewById(R.id.lblTodosReparaciones)
        chipCambiarEstado = findViewById(R.id.chipCambiarEstado)

        chipCambiarEstado.setOnClickListener {
            cambiarEstado()
        }
    }
    fun onClick( v: View? ){
        when(v?.id){
            R.id.btnConsultarComponente -> consultar()
        }
    }

    fun consultar() {
        val idText = id.text.toString()
        if (idText.isNotEmpty()) {
            val reparacionConsultada = Reparacion.buscarReparacionesPorId(idText)

            if (reparacionConsultada != null) {
                val reparaciones = Reparacion.obtenerTodosReparaciones()
                val reparacionesTexto = reparaciones.joinToString(separator = "\n") {
                    "ID: ${it.idR}\nCliente: ${it.correo_Cliente}\nEmpleado: ${it.correo_Empleado}\nFalla: ${it.falla}\nPlazo de Entrega: ${it.plazo_Entrega}\nEstado: ${it.estado}\n\n"
                }

                reparacionResultado.text = reparacionesTexto
                Toast.makeText(this, "Componente consultado exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El componente con el ID especificado no existe", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun cambiarEstado() {
        val idText = id.text.toString()
        if (idText.isNotEmpty()) {
            val estadoCambiado = Reparacion.cambiarEstadoAtrue(idText)
            if (estadoCambiado) {
                Toast.makeText(this, "Estado cambiado a true", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "No se encontró la reparación con el ID especificado", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor ingrese un ID válido", Toast.LENGTH_SHORT).show()
        }
    }
}