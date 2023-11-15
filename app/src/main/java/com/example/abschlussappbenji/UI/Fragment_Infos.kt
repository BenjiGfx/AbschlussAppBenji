package com.example.abschlussappbenji.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.abschlussappbenji.Adapter.Fragment_Infos_Adapter
import com.example.abschlussappbenji.Datenbank.TAG
import com.example.abschlussappbenji.databinding.FragmentInfosBinding

class Fragment_Infos: Fragment() {

    private val viewModel: InfosViewModel by viewModels()
    private lateinit var binding: FragmentInfosBinding


    //Hier wird die Logik aufgerufen und die XML-Datei ausgelesen und dem Fragment zur Verfügung gestellt.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.loadTeam()

        binding = FragmentInfosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewFragmentInfos.setHasFixedSize(true)

        viewModel.team.observe(viewLifecycleOwner) {
            Log.d(TAG, "$it")
            binding.recyclerviewFragmentInfos.adapter = Fragment_Infos_Adapter(it)
        }
    }

}