package com.example.settings2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.example.settings2.R
import com.example.settings2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        loadSettings()

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_home_to_settingsFragmenttester)
        }

        return binding.root

    }

    private fun loadSettings() {
        val sp=PreferenceManager.getDefaultSharedPreferences(requireContext())
        val signature=sp.getString("et","")
        binding.tReciveFromSettings.text=signature
        val categoryBoleanOne=sp.getBoolean("esempio_uno",false)

        if (categoryBoleanOne==false){
            Toast.makeText(requireContext(), "falso", Toast.LENGTH_SHORT).show()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        }else{
            Toast.makeText(requireContext(), "vero", Toast.LENGTH_SHORT).show()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }




    }


}