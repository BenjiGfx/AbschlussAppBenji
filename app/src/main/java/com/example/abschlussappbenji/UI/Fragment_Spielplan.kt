package com.example.abschlussappbenji.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.abschlussappbenji.Adapter.Fragment_Spielplan_Adapter
import com.example.abschlussappbenji.Datenbank.TAG

import com.example.abschlussappbenji.databinding.FragmentLigaSpielplanBinding

class Fragment_Spielplan: Fragment() {

    private val viewModel: SpielplanViewModel by viewModels()

    private lateinit var binding: FragmentLigaSpielplanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loadTeam()

        binding = FragmentLigaSpielplanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewSpielplan.setHasFixedSize(true)

        viewModel.spielplanteam.observe(viewLifecycleOwner) {
            Log.d(TAG, "$it")
            binding.recyclerViewSpielplan.adapter = Fragment_Spielplan_Adapter(it)
        }
    }
}