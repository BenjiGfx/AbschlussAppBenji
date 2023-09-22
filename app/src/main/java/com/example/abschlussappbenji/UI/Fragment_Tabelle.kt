package com.example.abschlussappbenji.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.abschlussappbenji.Adapter.Fragment_Tabelle_Adapter
import com.example.abschlussappbenji.Datenbank.TAG
import com.example.abschlussappbenji.databinding.FragmentLigaTabelleBinding

class Fragment_Tabelle: Fragment() {

    private val viewModel: TabellenViewModel by viewModels()
    private lateinit var binding: FragmentLigaTabelleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.loadTeam()

        binding = FragmentLigaTabelleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewLigaTabelle.setHasFixedSize(true)

        viewModel.team.observe(viewLifecycleOwner) {
            Log.d(TAG, "$it")
            binding.recyclerviewLigaTabelle.adapter = Fragment_Tabelle_Adapter(it)
        }
    }
}