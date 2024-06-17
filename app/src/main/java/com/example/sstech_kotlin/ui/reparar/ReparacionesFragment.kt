package com.example.sstech_kotlin.ui.reparar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sstech_kotlin.databinding.FragmentReparacionesBinding
import com.example.sstech_kotlin.modelo.Componente
import com.example.sstech_kotlin.modelo.Empleado
import com.example.sstech_kotlin.modelo.Reparacion
import com.example.sstech_kotlin.ui.componente.ComponentesViewModel
import com.example.sstech_kotlin.ui.empleado.RegistrarEmpleado

class ReparacionesFragment : Fragment() {

    private var _binding: FragmentReparacionesBinding? = null
    private val binding get() = _binding!!
    private lateinit var txtHistorial: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val reparacionesViewModel = ViewModelProvider(this).get(ReparacionesViewModel::class.java)

        _binding = FragmentReparacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        txtHistorial = binding.lblReparaciones

        val textView: TextView = binding.lblReparaciones
        reparacionesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val btnBuscarComponente: ImageButton = binding.btnBuscarReparacion
        btnBuscarComponente.setOnClickListener {
            cargarVentanBuscarReparaciones()
        }

        val btnActualizarComponentes: ImageButton = binding.btnActualizaReparaciones
        btnActualizarComponentes.setOnClickListener {
            mostrarTodasReparaciones()
        }

        mostrarTodasReparaciones()

        return root
    }

    private fun cargarVentanBuscarReparaciones() {
        val intent = Intent(activity, BuscarReparacion::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun mostrarTodasReparaciones() {
        val reparaciones = Reparacion.obtenerTodosReparaciones()
        val reaparacionesTexto = reparaciones.joinToString(separator = "\n") {
            "ID: ${it.idR}\nCliente: ${it.correo_Cliente}\nEmpleado: ${it.correo_Empleado}\nFalla: ${it.falla}\nPlazo de Entrega: ${it.plazo_Entrega}\nEstado: ${it.estado}\n\n"
        }
        txtHistorial.text = reaparacionesTexto
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
