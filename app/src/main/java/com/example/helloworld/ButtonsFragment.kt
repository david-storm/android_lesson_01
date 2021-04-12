package com.example.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.helloworld.databinding.FragmentButtonsBinding


class ButtonsFragment : Fragment() {

    private var countButtons: Int = 1
    private lateinit var binding: FragmentButtonsBinding
    private lateinit var countries: Array<String>
    private val MAX_COUNT_BUTTONS = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_buttons,
                container,
                false
            )

        countries = resources.getStringArray(R.array.numbers)
        binding.buttonOne.text = getString(R.string.button_number, countries[countButtons])
        binding.buttonPlus.setOnClickListener { addMoreButtons() }
        return binding.root
    }

    private fun addMoreButtons() {

        if (countButtons == MAX_COUNT_BUTTONS) {
            Toast.makeText(
                context, getString(R.string.many_buttons),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        countButtons++

        val btnNew = Button(context)
        btnNew.text = getString(R.string.button_number, countries[countButtons])
        btnNew.background = binding.buttonOne.background
        btnNew.setTextColor(binding.buttonOne.textColors)
        btnNew.layoutParams = binding.buttonOne.layoutParams
        btnNew.setPadding(
            binding.buttonOne.paddingLeft,
            binding.buttonOne.paddingTop,
            binding.buttonOne.paddingRight,
            binding.buttonOne.paddingBottom
        )
        binding.container.addView(btnNew)

    }
}