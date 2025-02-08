package com.example.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.repository.KisilerRepository
import com.example.kisileruygulamasi.room.DataBase
import com.example.kisileruygulamasi.room.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerRepository(kds: KisilerDataSource): KisilerRepository {
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(kdo: KisilerDao): KisilerDataSource {
        return KisilerDataSource(kdo)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): KisilerDao {
        val db = Room.databaseBuilder(context, DataBase::class.java, "kisiler.sqlite")
            .createFromAsset("kisiler.sqlite").build()
        return db.getKisilerDao()
    }
}