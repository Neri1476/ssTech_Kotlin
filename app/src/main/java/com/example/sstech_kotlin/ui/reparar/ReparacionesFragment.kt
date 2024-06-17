package com.example.sstech_kotlin.ui.reparar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sstech_kotlin.databinding.FragmentReparacionesBinding

class ReparacionesFragment : Fragment() {

    private var _binding: FragmentReparacionesBinding? = null
    private val binding get() = _binding!!
    private lateinit var reparacionesViewModel: ReparacionesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        reparacionesViewModel = ViewModelProvider(this).get(ReparacionesViewModel::class.java)

        _binding = FragmentReparacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Observamos las reparaciones
        reparacionesViewModel.reparaciones.observe(viewLifecycleOwner) { reparaciones ->
            val reparacionesText = reparaciones.joinToString(separator = "\n\n") { reparacion ->
                "${reparacion.descripcion} - ${reparacion.estado}"
            }
            binding.txtHistorial.text = reparacionesText
        }

        // Configuramos el botón de cambiar estado
        binding.btnCambiarEstado.setOnClickListener {
            reparacionesViewModel.cambiarEstadoReparacion()
        }

        // Configuramos el botón de regresar
        binding.btnVolver2.setOnClickListener {
            // Navegar a la pantalla anterior
            // Por ejemplo, si estás usando Navigation Component:
            // findNavController().navigateUp()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
