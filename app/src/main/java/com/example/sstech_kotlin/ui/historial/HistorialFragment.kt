package com.example.sstech_kotlin.ui.historial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sstech_kotlin.databinding.FragmentHistorialBinding

class HistorialFragment : Fragment() {

    private var _binding: FragmentHistorialBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private lateinit var historialViewModel: HistorialViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        historialViewModel = ViewModelProvider(this).get(HistorialViewModel::class.java)

        _binding = FragmentHistorialBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val resultadoHistorial: TextView = binding.lblTodosHistorial
        historialViewModel.historial.observe(viewLifecycleOwner) { historial ->
            resultadoHistorial.text = if (historial.isNotEmpty()) {
                historial.joinToString(separator = "\n\n")
            } else {
                "Sin historial de pedidos"
            }
        }

        // Configuracion el botón de regresar
        binding.btnRegresar.setOnClickListener {
            findNavController().navigateUp()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
