package com.example.sstech_kotlin.ui.reparar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sstech_kotlin.databinding.FragmentReparacionesBinding

class ReparacionesFragment : Fragment() {

    private var _binding: FragmentReparacionesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val galleryViewModel =
            ViewModelProvider(this).get(ReparacionesViewModel::class.java)

        _binding = FragmentReparacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.lblReparaciones
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