package com.example.practicajaula

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager


import com.example.practicajaula.Historico.guardar
import com.example.practicajaula.databinding.FragmentRecyclerViewBinding


class RecyclerView : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        binding.rvPeso.apply {

            layoutManager = LinearLayoutManager(this.context)

            adapter = RecyclerAdapter(guardar)
        }
        return binding.root
    }

}