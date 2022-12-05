package com.example.practicajaula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicajaula.databinding.PesoBinding

class RecyclerAdapter(private var guardar: List<Guardar>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holderMy: MyViewHolder, position: Int) {
        val item = guardar[position]
        holderMy.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            PesoBinding.inflate(
                layoutInflater,
                parent,
                false
            ).root
        )
    }

    override fun getItemCount(): Int {
        return guardar.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PesoBinding.bind(view)

        fun bind(guardar: Guardar) {
            binding.tvImc.text = guardar.peso1.toString()
            binding.tvGenero.text = guardar.sexo1
            binding.tvFecha.text = guardar.fechita1
            binding.tvEstado.text = guardar.comoEstar1

        }
    }
}