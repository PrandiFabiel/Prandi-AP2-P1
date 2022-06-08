package com.example.prandi_ap2_p1.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Prestamos")
@Parcelize
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,
    val deudor: String,
    val concepto: String,
    val monto: Float
): Parcelable
