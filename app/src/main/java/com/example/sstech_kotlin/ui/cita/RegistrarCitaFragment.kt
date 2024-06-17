package com.example.sstech_kotlin.ui.cita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sstech_kotlin.databinding.FragmentRegistrarCitaBinding
import com.example.sstech_kotlin.modelo.Reparacion
import java.util.*

class RegistrarCitaFragment : Fragment() {

    private var _binding: FragmentRegistrarCitaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(RegistrarCitaModel::class.java)

        _binding = FragmentRegistrarCitaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView = binding.lblRegistrarCita
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnAgregarCita.setOnClickListener {
            val correoCliente = binding.txtDireccion.text.toString()
            val plazoEntrega = Date() // Convierte tu EditText a Date aquí
            val correoEmpleado = "empleado@ejemplo.com" // Puedes cambiar esto por una selección de spinner o algo similar
            val falla = binding.txtFalla.text.toString()
            val estado = false

            if (correoCliente.isNotEmpty() && falla.isNotEmpty()) {
                val nuevaReparacion = Reparacion(UUID.randomUUID().toString(), correoCliente, correoEmpleado, falla, plazoEntrega, estado)
                Reparacion.agregarPedido(nuevaReparacion)
                Toast.makeText(context, "Cita registrada exitosamente", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Por favor completa todos los campos", Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
