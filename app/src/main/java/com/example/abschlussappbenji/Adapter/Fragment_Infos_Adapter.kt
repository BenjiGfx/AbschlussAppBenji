package com.example.abschlussappbenji.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.abschlussappbenji.DatenKlassen.DatenTabelle
import com.example.abschlussappbenji.Datenbank.TAG
import com.example.abschlussappbenji.UI.Fragment_Infos
import com.example.abschlussappbenji.databinding.ListItemInfosBinding

class Fragment_Infos_Adapter(
    private val dataset: List<DatenTabelle>
) : RecyclerView.Adapter<Fragment_Infos_Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemInfosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemInfosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        Log.d(TAG, "$item")

        holder.binding.vereinlogoInfos.load(item.teamIconUrl)
        holder.binding.gamesScore.text = item.matches.toString()
        holder.binding.winsScore.text = item.won.toString()
        holder.binding.drawsScore.text = item.draw.toString()
        holder.binding.lossesScore.text = item.lost.toString()
        holder.binding.differenceScore.text = item.goalDiff.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}