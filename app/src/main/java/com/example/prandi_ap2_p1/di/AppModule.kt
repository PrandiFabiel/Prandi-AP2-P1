package com.example.prandi_ap2_p1.di

import android.content.Context
import androidx.room.Room
import com.example.prandi_ap2_p1.data.PrestamoDao
import com.example.prandi_ap2_p1.data.PrestamoRepository
import com.example.prandi_ap2_p1.data.PrestamosDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvidePrestamosDb(@ApplicationContext context: Context): PrestamosDb {
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            "PrestamoDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePrestamoDAO(prestamosDb: PrestamosDb): PrestamoDao{
        return prestamosDb.prestamoDao
    }

    @Provides
    fun ProvidePrestamoRepository(prestamoDao: PrestamoDao): PrestamoRepository{
        return PrestamoRepository(prestamoDao)
    }
}