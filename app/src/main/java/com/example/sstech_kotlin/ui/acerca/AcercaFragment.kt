package com.example.sstech_kotlin.ui.acerca

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.databinding.FragmentAcercaBinding

class AcercaFragment : Fragment() {

    private var _binding: FragmentAcercaBinding? = null

    companion object {
        fun newInstance() = AcercaFragment()
    }

    private val binding get() = _binding!!
    private lateinit var viewModel: AcercaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contactoViewModel =
            ViewModelProvider(this).get(AcercaViewModel::class.java)

        _binding = FragmentAcercaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.txtTitulo
        contactoViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AcercaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}