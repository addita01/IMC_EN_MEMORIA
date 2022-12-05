package com.example.practicajaula

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practicajaula.databinding.FragmentMyImcBinding
import androidx.navigation.fragment.findNavController
import java.util.*

class CalcIMC : Fragment() {
    private lateinit var binding: FragmentMyImcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyImcBinding.inflate(inflater, container, false)




        binding.btn.setOnClickListener {
            if (binding.peso.text.isEmpty() || binding.altura.text.isEmpty()) {
                Toast.makeText(requireActivity(), "UPS!!! te faaltan campitos :)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            val hoy = Calendar.getInstance()
            val fecha = "${hoy.get(Calendar.DAY_OF_MONTH)}-${hoy.get(Calendar.MONTH) + 1}-${hoy.get(Calendar.YEAR)}"
            val peso = binding.peso.text.toString().toDouble()
            val altura = binding.altura.text.toString().toDouble() / 100
            val resultado = peso / (altura * altura)
            val genero: String
            val comoEstar =  checkResult(resultado, if (binding.hombre.isChecked) true else false)
            genero = if (binding.hombre.isChecked){
                "Hombre"
            } else "Mujer"


            binding.resultadoimpreso.text = resultado.toString()
            // binding.comoestar.text = como_estar.toString()
            binding.comoestar.text = comoEstar

            Historico.guardar.add(Guardar(resultado,genero,"",comoEstar))

        }

        binding.btnHistorico.setOnClickListener{
            findNavController().navigate(
                CalcIMCDirections.actionMyImcToRecyclerView()
            )
        }

        return binding.root


    }

    private fun checkResult(resultado: Double, ishombre: Boolean): String {

        if (ishombre) {
            return when {
                resultado <= 18 ->  "muy delgado"
                resultado in 18.5..25.1 ->  "normal"
                resultado in 25.2..30.1 ->  "sobrepeso"


                else -> "obseo"
            }
        } else {
            return when {
                resultado <= 20 -> "muy delgado"
                resultado in 20.5..30.1 -> "normal"
                resultado in 30.2..35.1 -> "sobre peso"
                else -> "obeso"
            }
        }

    }

}