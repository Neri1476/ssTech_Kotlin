package com.example.sstech_kotlin.ui.empleado


import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.example.sstech_kotlin.databinding.FragmentEmpleadosBinding
import com.example.sstech_kotlin.modelo.Empleado

class EmpleadosFragment : Fragment() {

    private var _binding: FragmentEmpleadosBinding? = null
    private val binding get() = _binding!!
    private lateinit var resultadoEmpleados: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val empleadosViewModel = ViewModelProvider(this).get(EmpleadosViewModel::class.java)

        _binding = FragmentEmpleadosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        resultadoEmpleados = binding.lblTodosEmpleados

        val textView: TextView = binding.lblEmpleados
        empleadosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val btnAgregarEmpleado: ImageButton = binding.btnAgregarEmpleado
        btnAgregarEmpleado.setOnClickListener {
            cargarVentanRegistrarEmpleado()
        }

        val btnBuscarEmpleado: ImageButton = binding.btnBuscarEmpleado
        btnBuscarEmpleado.setOnClickListener {
            cargarVentanBuscarEmpleado()
        }

        val btnActualizarEmpleados: ImageButton = binding.btnActualizaEmpleado
        btnActualizarEmpleados.setOnClickListener {
            mostrarTodosEmpleados()
        }

        mostrarTodosEmpleados()

        return root
    }

    private fun cargarVentanRegistrarEmpleado() {
        val intent = Intent(activity, RegistrarEmpleado::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun cargarVentanBuscarEmpleado() {
        val intent = Intent(activity, ModificarEmpleado::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun mostrarTodosEmpleados() {
        val empleados = Empleado.listaEmpleados
        val empleadosTexto = empleados.joinToString(separator = "\n") {
            "Correo: ${it.correo}\nNombre: ${it.nombre} ${it.apellido}\nTeléfono: ${it.telefono}\nPuesto: ${it.puesto}\nEspecialidad: ${it.especialidad}\nHorario: ${it.horario}\nFecha de Contratación: ${it.fechaContratacion}\nSalario: ${it.salario}\n\n"
        }
        resultadoEmpleados.text = empleadosTexto
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}