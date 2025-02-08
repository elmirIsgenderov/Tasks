package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repository.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class kisiKayitViewModel @Inject constructor(var krepo: KisilerRepository) : ViewModel() {

    fun kaydet(name: String, number: String) {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.save(name, number)
        }
    }
}