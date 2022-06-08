package com.example.prandi_ap2_p1.data

import com.example.prandi_ap2_p1.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
) {
    suspend fun Insertar(prestamo: Prestamo){
        prestamoDao.Insertar(prestamo)
    }

    suspend fun Eliminar(prestamo: Prestamo){
        prestamoDao.Eliminar(prestamo)
    }

    fun Buscar(prestamoId: Int): Flow<List<Prestamo>>{
        return prestamoDao.buscar(prestamoId)
    }

    fun GetLista(): Flow<List<Prestamo>>{
        return prestamoDao.getLista()
    }
}