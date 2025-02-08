package com.example.kisileruygulamasi.data.repository

import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds: KisilerDataSource) {

    suspend fun save(name: String, number: String) = kds.save(name, number)
    suspend fun update(id: Int, name: String, number: String) =
        kds.update(id, name, number)

    suspend fun delete(id: Int) = kds.delete(id)
    suspend fun upload(): List<Kisiler> = kds.upload()
    suspend fun search(search: String): List<Kisiler> = kds.search(search)

}