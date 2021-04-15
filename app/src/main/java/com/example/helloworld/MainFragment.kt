package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.helloworld.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main, container, false
        )

        binding.buttonToButtons.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_buttonsFragment)
        }
        binding.buttonToInputs.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_inputsFragment)
        }
        binding.buttonToRadios.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_radiosFragment)
        }

        return binding.root
    }

}