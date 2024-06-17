package com.example.sstech_kotlin.ui.reparar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sstech_kotlin.R
import com.example.sstech_kotlin.modelo.Reparacion

class ReparacionesAdapter(private val reparaciones: List<Reparacion>) :
    RecyclerView.Adapter<ReparacionesAdapter.ReparacionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReparacionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reparacion, parent, false)
        return ReparacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReparacionViewHolder, position: Int) {
        val reparacion = reparaciones[position]
        holder.bind(reparacion)
    }

    override fun getItemCount() = reparaciones.size

    inner class ReparacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val textViewIdR: TextView = itemView.findViewById(R.id.textViewIdR)
        private val textViewCorreoCliente: TextView = itemView.findViewById(R.id.textViewCorreoCliente)
        private val textViewCorreoEmpleado: TextView = itemView.findViewById(R.id.textViewCorreoEmpleado)
        private val textViewFalla: TextView = itemView.findViewById(R.id.textViewFalla)
        private val textViewPlazoEntrega: TextView = itemView.findViewById(R.id.textViewPlazoEntrega)
        private val textViewEstado: TextView = itemView.findViewById(R.id.textViewEstado)

        fun bind(reparacion: Reparacion)
        {
            textViewIdR.text = reparacion.idR
            textViewCorreoCliente.text = reparacion.correo_Cliente
            textViewCorreoEmpleado.text = reparacion.correo_Empleado
            textViewFalla.text = reparacion.falla
            textViewPlazoEntrega.text = reparacion.plazo_Entrega.toString()
            textViewEstado.text = if (reparacion.estado) "Terminada" else "En proceso"
        }
    }
}
