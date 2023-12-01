package com.example.advancednavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.advancednavigation.databinding.FragmentSettingsABinding

class SettingsAFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentSettingsABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNavigateB.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.btnNavigateB->findNavController().navigate(R.id.action_settingsAFragment_to_BFragment)
        }
    }


}