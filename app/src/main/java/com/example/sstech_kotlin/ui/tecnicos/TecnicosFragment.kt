package com.example.sstech_kotlin.ui.tecnicos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.databinding.FragmentAcercaBinding
import com.example.sstech_kotlin.databinding.FragmentTecnicosBinding
import com.example.sstech_kotlin.modelo.Componente
import com.example.sstech_kotlin.modelo.Empleado
import com.example.sstech_kotlin.ui.acerca.AcercaViewModel

class TecnicosFragment : Fragment() {

    private var _binding: FragmentTecnicosBinding? = null

    private val binding get() = _binding!!
    private lateinit var resultadoTecnicos: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contactoViewModel =
            ViewModelProvider(this).get(TecnicosViewModel::class.java)

        _binding = FragmentTecnicosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.lblTecnicos
        contactoViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        mostrarTodosTecnicos()
        return root
    }
    private fun mostrarTodosTecnicos() {
        val empleado = Empleado.obtenerTodosTecnicos()
        val empleadosTexto = empleado.joinToString(separator = "\n") {
            "Correo: ${it.correo}, Nombre: ${it.nombre}, Apellido: ${it.apellido}, Telefono: ${it.telefono}}"
        }
        resultadoTecnicos.text = empleadosTexto
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}