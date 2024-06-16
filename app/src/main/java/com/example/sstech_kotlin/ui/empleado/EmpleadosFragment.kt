package com.example.sstech_kotlin.ui.empleado

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.databinding.FragmentEmpleadosBinding
import com.example.sstech_kotlin.databinding.FragmentRegistrarCitaBinding
import com.example.sstech_kotlin.ui.cita.RegistrarCitaModel

class EmpleadosFragment : Fragment() {

    private var _binding: FragmentEmpleadosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val galleryViewModel =
            ViewModelProvider(this).get(EmpleadosViewModel::class.java)

        _binding = FragmentEmpleadosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.lblEmpleados
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}