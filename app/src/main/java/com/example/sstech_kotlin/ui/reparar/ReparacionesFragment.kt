package com.example.sstech_kotlin.ui.reparar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sstech_kotlin.databinding.FragmentReparacionesBinding
import com.example.sstech_kotlin.modelo.Empleado

class ReparacionesFragment : Fragment() {

    private var _binding: FragmentReparacionesBinding? = null
    private val binding get() = _binding!!
    private lateinit var txtHistorial: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReparacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        txtHistorial = binding.txtHistorial

        mostrarTodasReparaciones()

        return root
    }

    private fun mostrarTodasReparaciones() {
        val empleados = Empleado.obtenerTodosTecnicos()
        val reparacionesTexto = StringBuilder()

        for (empleado in empleados) {
            reparacionesTexto.append("Técnico: ${empleado.nombre}\n")
            reparacionesTexto.append("Correo: ${empleado.correo}\n")
            reparacionesTexto.append("Puesto: ${empleado.puesto}\n")
            reparacionesTexto.append("Especialidad: ${empleado.especialidad}\n")
            reparacionesTexto.append("Horario: ${empleado.horario}\n")
            reparacionesTexto.append("Fecha Contratación: ${empleado.fechaContratacion}\n")
            reparacionesTexto.append("Salario: ${empleado.salario}\n\n")
        }

        if (reparacionesTexto.isEmpty()) {
            txtHistorial.text = "No hay técnicos registrados."
        } else {
            txtHistorial.text = reparacionesTexto.toString().trim()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
