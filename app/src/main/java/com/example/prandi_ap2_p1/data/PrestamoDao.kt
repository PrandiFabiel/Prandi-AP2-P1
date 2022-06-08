package com.example.prandi_ap2_p1.data

import androidx.room.*
import com.example.prandi_ap2_p1.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(prestamo: Prestamo)

    @Delete
    suspend fun Eliminar(prestamo: Prestamo)

    @Query("SELECT * FROM Prestamos WHERE prestamoId =:prestamoId")
    fun buscar(prestamoId: Int): Flow<List<Prestamo>>

    @Query("SELECT * FROM Prestamos ORDER BY prestamoId")
    fun getLista(): Flow<List<Prestamo>>
}