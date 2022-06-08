package com.example.prandi_ap2_p1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prandi_ap2_p1.model.Prestamo

@Database(
    entities = [Prestamo::class],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract val prestamoDao: PrestamoDao
}