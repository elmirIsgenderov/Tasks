package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repository.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor(var krepo: KisilerRepository) : ViewModel() {

    val kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        upload()
    }

    fun delete(delete: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.delete(delete)
            upload()
        }
    }

    fun upload() {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.upload()
        }
    }

    fun search(search: String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.search(search)
        }
    }

}