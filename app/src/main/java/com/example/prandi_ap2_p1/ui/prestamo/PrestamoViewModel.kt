package com.example.prandi_ap2_p1.ui.prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prandi_ap2_p1.data.PrestamoRepository
import com.example.prandi_ap2_p1.model.Prestamo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamoRepository: PrestamoRepository
): ViewModel() {

    var id by mutableStateOf(0)
    var deudor by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")

    var prestamos = prestamoRepository.GetLista()
    private set

    fun Guardar(){
        viewModelScope.launch {
            prestamoRepository.Insertar(
                Prestamo(
                    prestamoId = id,
                    deudor = deudor,
                    concepto = concepto,
                    monto = monto.toFloat()
                )
            )
        }
    }
}