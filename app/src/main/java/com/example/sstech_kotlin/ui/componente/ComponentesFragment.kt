package com.example.sstech_kotlin.ui.componente

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.example.sstech_kotlin.databinding.FragmentComponentesBinding
import com.example.sstech_kotlin.modelo.Componente

class ComponentesFragment : Fragment() {

    private var _binding: FragmentComponentesBinding? = null
    private val binding get() = _binding!!
    private lateinit var resultadoComponetes: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val componentesViewModel = ViewModelProvider(this).get(ComponentesViewModel::class.java)

        _binding = FragmentComponentesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        resultadoComponetes = binding.lblTodosComponentes

        val textView: TextView = binding.lblComponentes
        componentesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val btnAgregarComponente: ImageButton = binding.btnAgregarComponente
        btnAgregarComponente.setOnClickListener {
            cargarVentanRegistrarComponente()
        }

        val btnBuscarComponente: ImageButton = binding.btnBuscarComponente
        btnBuscarComponente.setOnClickListener {
            cargarVentanBuscarComponente()
        }

        val btnActualizarComponentes: ImageButton = binding.btnActualizaComponente
        btnActualizarComponentes.setOnClickListener {
            mostrarTodosComponentes()
        }

        mostrarTodosComponentes()

        return root
    }

    private fun cargarVentanRegistrarComponente() {
        val intent = Intent(activity, RegistrarComponente::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun cargarVentanBuscarComponente() {
        val intent = Intent(activity, FormularioBMComponente::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun mostrarTodosComponentes() {
        val componentes = Componente.obtenerTodosComponentes()
        val componentesTexto = componentes.joinToString(separator = "\n") {
            "ID: ${it.id}\nNombre: ${it.nombre}\nCantidad: ${it.cantidad}\nPrecio: ${it.precio}\nProveedor: ${it.provedor}\n\n"
        }
        resultadoComponetes.text = componentesTexto
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}