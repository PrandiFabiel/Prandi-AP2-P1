package com.example.prandi_ap2_p1.util

sealed class Screen(val route: String){
    object nameRegistro: Screen("Registro")
    object nameConsulta: Screen("List")
}
