package com.example.practicajaula

data class Guardar(val peso: Double, val sexo: String, val fechita: String, val comoEstar: String) {
    var peso1: Double? = null
    var sexo1: String? = null
    var fechita1: String? = null
    var comoEstar1: String? = null

    init {
        this.peso1 = peso
        this.sexo1 = sexo
        this.fechita1 = fechita
        this.comoEstar1 = comoEstar
    }
}
