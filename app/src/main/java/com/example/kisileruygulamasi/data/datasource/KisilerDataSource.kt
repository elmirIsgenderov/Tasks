package com.example.kisileruygulamasi.data.datasource

import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdo: KisilerDao) {

    suspend fun upload(): List<Kisiler> =
        withContext(Dispatchers.IO) {
            return@withContext kdo.kisiYukle()
        }

    suspend fun search(search: String): List<Kisiler> =
        withContext(Dispatchers.IO) {
            return@withContext kdo.kisiAra(search)
        }

    suspend fun save(name: String, number: String) {
        val kisi = Kisiler(0, name, number)
        kdo.kaydet(kisi)
    }

    suspend fun update(id: Int, name: String, number: String) {
        val update = Kisiler(id, name, number)
        kdo.guncelle(update)
    }

    suspend fun delete(id: Int) {
        val delete = Kisiler(id, "", "")
        kdo.sil(delete)
    }
}