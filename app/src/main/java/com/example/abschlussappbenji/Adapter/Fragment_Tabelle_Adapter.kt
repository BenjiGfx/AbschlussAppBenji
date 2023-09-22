package com.example.abschlussappbenji.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.abschlussappbenji.DatenKlassen.DatenTabelle
import com.example.abschlussappbenji.Datenbank.TAG
import com.example.abschlussappbenji.databinding.ListItemTabelleBinding

class Fragment_Tabelle_Adapter(
    private val dataset: List<DatenTabelle>
) : RecyclerView.Adapter<Fragment_Tabelle_Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemTabelleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemTabelleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        Log.d(TAG, "$item")

        holder.binding.vereinLogo.load(item.teamIconUrl)
        holder.binding.vereinName.text = item.teamName
        holder.binding.ligaPunkte.text = item.points.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}