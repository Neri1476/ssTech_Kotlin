package com.example.sstech_kotlin.inicio

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Usuario
import com.example.sstech_kotlin.MainActivity
import com.example.sstech_kotlin.modelo.Cliente

class Login : AppCompatActivity() {

    private lateinit var correo: EditText
    private lateinit var contrasena: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        correo = findViewById(R.id.txtCorreo)
        contrasena = findViewById(R.id.txtContrasena)
    }

    fun onClick( v: View? ){
        when(v?.id){
            R.id.btnIngresar -> ingresar()
            R.id.btnSalir -> salir()
            R.id.btnRegistrar -> registrarUsuario()
        }
    }

    /*fun ingresar(){
        if (camposCompletos()) {
            if (correo.text.toString() == "admin@sstech.mx" && contrasena.text.toString() == "1234") {
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra("user_type", "admin")
                startActivity(intent)
            } else {
                val cliente = Cliente.login(correo.text.toString(), contrasena.text.toString())

                if (cliente != null) {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    intent.putExtra("user_type", "client")
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
        }
    }*/
    fun ingresar(){
        if (camposCompletos()) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

            if (correo.text.toString() == "admin@sstech.mx" && contrasena.text.toString() == "1234") {
                intent.putExtra("user_type", "admin")
            } else {
                val cliente = Cliente.login(correo.text.toString(), contrasena.text.toString())
                if (cliente != null) {
                    intent.putExtra("user_type", "client")
                } else {
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
        }
    }


    fun salir(){
        finish()
    }

    fun camposCompletos() : Boolean {
        return correo.text.isNotEmpty() && contrasena.text.isNotEmpty()
    }

    private fun guardarPreferencias(user: Usuario){
        val preferences : SharedPreferences = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preferences.edit()

        editor.putString("email", user.correo)
        editor.putString("password", user.contrasena)
        editor.apply()
    }

    fun registrarUsuario() {
        val intent = Intent(applicationContext, RegistrarUsuario::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}