package com.example.practicajaula

import androidx.appcompat.app.AppCompatActivity
import com.example.practicajaula.databinding.ActivityMainBinding
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }
    }