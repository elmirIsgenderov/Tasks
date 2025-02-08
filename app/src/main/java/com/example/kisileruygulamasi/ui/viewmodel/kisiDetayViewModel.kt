package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repository.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class kisiDetayViewModel @Inject constructor(var krepo: KisilerRepository) : ViewModel() {


    fun guncelle(id: Int, name: String, number: String) {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.update(id, name, number)
        }
    }
}