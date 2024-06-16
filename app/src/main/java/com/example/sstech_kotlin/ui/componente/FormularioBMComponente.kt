package com.example.sstech_kotlin.ui.componente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Componente

class FormularioBMComponente : AppCompatActivity() {

    private lateinit var id: EditText
    private lateinit var nombre: EditText
    private lateinit var cantidad: EditText
    private lateinit var precioUnitario: EditText
    private lateinit var proveedor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_bmcomponente)
        supportActionBar?.hide()

        id = findViewById(R.id.txtIdComponente)
        nombre = findViewById(R.id.txtNombreComponente)
        cantidad = findViewById(R.id.txtCantidadComponente)
        precioUnitario = findViewById(R.id.txtPrecioUnitarioComponente)
        proveedor = findViewById(R.id.txtProvedorComponente)
    }

    fun onClick( v: View? ){
        when(v?.id){
            R.id.btnConsultarComponente -> consultar()
            R.id.btnModificarComponente -> modificar()
            R.id.btnRegresar -> regresar()
        }
    }

    fun consultar() {
        if (id.text.toString().isNotEmpty()) {
            val idInt = id.text.toString().toInt()
            val componenteConsltado = Componente.buscarComponentePorId(idInt)

            if (componenteConsltado != null) {
                nombre.setText(componenteConsltado.nombre)
                cantidad.setText(componenteConsltado.cantidad)
                precioUnitario.setText(componenteConsltado.precio)
                proveedor.setText(componenteConsltado.provedor)

                Toast.makeText(this, "Componente consultado exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El componente con el ID especificado no existe", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun modificar() {
        if (id.text.toString().isNotEmpty() || camposCompletos()) {
            val idInt = id.text.toString().toInt()
            val componenteModificado = Componente.modificarComponente(idInt, nombre.text.toString(), cantidad.text.toString(), precioUnitario.text.toString(),
                proveedor.text.toString())

            if (componenteModificado != null) {
                nombre.setText(componenteModificado.nombre)
                cantidad.setText(componenteModificado.cantidad)
                precioUnitario.setText(componenteModificado.precio)
                proveedor.setText(componenteModificado.provedor)

                Toast.makeText(this, "Componente modificado exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El componente con el ID especificado no existe", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Complete el campo id o rellene todos los campos", Toast.LENGTH_SHORT).show()
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