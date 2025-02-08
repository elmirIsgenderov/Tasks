package com.example.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.kisileruygulamasi.R

fun Navigation.kecid(it: View, id: Int) {
    Navigation.findNavController(it).navigate(id)
}

fun Navigation.kecid(it: View, id: NavDirections) {
    Navigation.findNavController(it).navigate(id)
}