package com.example.sstech_kotlin.ui.reparar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sstech_kotlin.databinding.FragmentReparacionesBinding
import com.example.sstech_kotlin.modelo.Reparacion

class ReparacionesFragment : Fragment() {

    private var _binding: FragmentReparacionesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reparacionesViewModel =
            ViewModelProvider(this).get(ReparacionesViewModel::class.java)

        _binding = FragmentReparacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerViewReparaciones.layoutManager = LinearLayoutManager(context)
        val adapter = ReparacionesAdapter(Reparacion.listaReparaciones)
        binding.recyclerViewReparaciones.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
