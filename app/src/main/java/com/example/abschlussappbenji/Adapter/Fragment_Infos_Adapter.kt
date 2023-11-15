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


// Der Adapter verbindet das Fragment mit den Daten und erstellt für jedes Item eine View und stellt sie der Recyclerview zur Verfügung.
class Fragment_Infos_Adapter(
    private val dataset: List<DatenTabelle>
) : RecyclerView.Adapter<Fragment_Infos_Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemInfosBinding) : RecyclerView.ViewHolder(binding.root)


    // ViewHolder erstellen. Inflation des Layouts. Initialisierung des ViewHolder (XML-Layout wird in ein View-Objekt instanziiert.)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemInfosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    //Hier werden die Daten eines Items an den zugehörigen ItemViewHolder gebunden.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        Log.d(TAG, "$item")

        holder.binding.vereinlogoInfos.load(item.teamIconUrl)  // Hier wird per coil ein Bild aus der API geladen.
        holder.binding.gamesScore.text = item.matches.toString()
        holder.binding.winsScore.text = item.won.toString()
        holder.binding.drawsScore.text = item.draw.toString()
        holder.binding.lossesScore.text = item.lost.toString()
        holder.binding.differenceScore.text = item.goalDiff.toString()
        holder.binding.verinsnameFragmentInfos.text = item.teamName
    }

    // Hier wird die größe der Liste der Variable "dataset" and den Adapter zurückgegeben.
    override fun getItemCount(): Int {
        return dataset.size
    }
}