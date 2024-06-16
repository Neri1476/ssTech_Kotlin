package com.example.sstech_kotlin.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Cliente
import java.text.SimpleDateFormat
import java.util.Date

class RegistrarUsuario : AppCompatActivity() {

    private lateinit var correo: EditText
    private lateinit var contrasena: EditText
    private lateinit var nombre: EditText
    private lateinit var apellido: EditText
    private lateinit var direccion: EditText
    private lateinit var telefono: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)
        supportActionBar?.hide()

        correo = findViewById(R.id.txtCorreo)
        contrasena = findViewById(R.id.txtContrasena)
        nombre = findViewById(R.id.txtNombre)
        apellido = findViewById(R.id.txtApellido)
        direccion = findViewById(R.id.txtDireccion)
        telefono = findViewById(R.id.txtTelefono)
    }

    fun onClick( v: View? ){
        when(v?.id){
            R.id.btnRegistrar -> registrar()
            R.id.btnRegresar -> regresar()
        }
    }

    fun registrar() {
        val formato = SimpleDateFormat("dd/MM/yy")
        val fecha = formato.format(Date())

        if (camposCompletos()) {
            val nuevoCliente = Cliente(correo.text.toString(), contrasena.text.toString(), nombre.text.toString(),
                apellido.text.toString(), direccion.text.toString(), telefono.text.toString(), fecha)
            Cliente.agregarCliente(nuevoCliente)

            Toast.makeText(this, "Registrado con exito con nombre " + nombre.text.toString(), Toast.LENGTH_SHORT).show()

            val intent = Intent(applicationContext, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        } else {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun regresar() {
        val intent = Intent(applicationContext, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun camposCompletos() : Boolean {
        return correo.text.isNotEmpty() && contrasena.text.isNotEmpty()
                && nombre.text.isNotEmpty() && apellido.text.isNotEmpty()
                && direccion.text.isNotEmpty() && telefono.text.isNotEmpty()
    }
}