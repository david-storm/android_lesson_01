package com.example.helloworld

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.helloworld.databinding.FragmentInputsBinding


class InputsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentInputsBinding>(
                inflater,
                R.layout.fragment_inputs,
                container,
                false
            )
        binding.button.text = getString(R.string.hide_keyboard, System.getProperty("line.separator"))
        binding.button.setOnClickListener {
            hideKeyboard(it)
        }

        return binding.root
    }

    fun hideKeyboard(view: View){
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}