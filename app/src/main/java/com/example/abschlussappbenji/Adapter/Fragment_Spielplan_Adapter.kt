package com.example.abschlussappbenji.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abschlussappbenji.DatenKlassen.SpData
import com.example.abschlussappbenji.databinding.ListItemSpielplanBinding

class Fragment_Spielplan_Adapter(
    private val dataset: List<SpData>
) : RecyclerView.Adapter<Fragment_Spielplan_Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemSpielplanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemSpielplanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.team1.text = item.team1.teamName
        holder.binding.team2.text = item.team2.teamName

        if (item.matchResults.size != 0) {

            holder.binding.ergebnisTeam1.text = item.matchResults[1].pointsTeam1.toString()
            holder.binding.ergebnisTeam2.text = item.matchResults[1].pointsTeam2.toString()
        } else {
            holder.binding.ergebnisTeam1.text = "/"
            holder.binding.ergebnisTeam2.text = "/"
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }
}