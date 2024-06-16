package com.example.sstech_kotlin.ui.componente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.inicio.Login
import com.example.sstech_kotlin.modelo.Cliente
import com.example.sstech_kotlin.modelo.Componente
import java.text.SimpleDateFormat
import java.util.Date

class RegistrarComponente : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var cantidad: EditText
    private lateinit var precioUnitario: EditText
    private lateinit var proveedor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_componente)
        supportActionBar?.hide()

        nombre = findViewById(R.id.txtNombreComponente)
        cantidad = findViewById(R.id.txtCantidadComponente)
        precioUnitario = findViewById(R.id.txtPrecioUnitarioComponente)
        proveedor = findViewById(R.id.txtProvedorComponente)
    }

    fun onClick( v: View? ){
        when(v?.id){
            R.id.btnRegistrar -> registrar()
            R.id.btnRegresar -> regresar()
        }
    }

    fun registrar() {
        if (camposCompletos()) {
            var idComponente = Componente.logitudComponente()+1
            val nuevoComponente = Componente(idComponente++, nombre.text.toString(), cantidad.text.toString(), precioUnitario.text.toString(),
                proveedor.text.toString())
            Componente.agregarComponente(nuevoComponente)
            Toast.makeText(this, "Registrado con exito con id: " + nuevoComponente.id + " con nombre " +
                    nuevoComponente.nombre, Toast.LENGTH_SHORT).show()

            finish()
        } else {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun regresar() {
        finish()
    }

    fun camposCompletos() : Boolean {
        return nombre.text.isNotEmpty() && cantidad.text.isNotEmpty()
                && precioUnitario.text.isNotEmpty() && proveedor.text.isNotEmpty()
    }
}