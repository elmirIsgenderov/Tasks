package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardViewBinding
import com.example.kisileruygulamasi.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnaSayfaViewModel
import com.example.kisileruygulamasi.utils.kecid
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(
    private var context: Context,
    private var kisilerListesi: List<Kisiler>,
    private val viewModel: AnaSayfaViewModel
) :
    RecyclerView.Adapter<KisilerAdapter.savingCard>() {

    inner class savingCard(var view: CardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): savingCard {
        val binding = CardViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return savingCard(binding)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: savingCard, position: Int) {
        val kisi = kisilerListesi[position]
        val holder1 = holder.view

        holder1.kisi = kisi

        holder1.cardSatir.setOnClickListener {
            val kecis = AnasayfaFragmentDirections.kecidKisiDetay(kisi)
            Navigation.kecid(it, kecis)
        }

        holder1.imgSil.setOnClickListener {
            Snackbar.make(it, "Silinminsi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    viewModel.delete(kisi.kisi_id)
                    viewModel.upload()
                }
                .show()
        }

    }
}