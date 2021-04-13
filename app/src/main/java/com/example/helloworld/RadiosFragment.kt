package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import com.example.helloworld.databinding.FragmentRadiosBinding

class RadiosFragment : Fragment() {

    private lateinit var binding: FragmentRadiosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_radios, container, false)

        binding.apply {
            checkBoxMain.setOnCheckedChangeListener { it, isChecked ->
                checkBoxToggleMain(it, isChecked)
            }
            checkBoxRadios.setOnCheckedChangeListener { it, isChecked ->
                checkBoxToggleRadios(it, isChecked)
            }
            checkBoxSlider.setOnCheckedChangeListener { it, isChecked ->
                checkBoxToggleSlider(it, isChecked)
            }
            radioGroup.setOnCheckedChangeListener { it, checkedId -> radiosToggle(it, checkedId) }
        }

        sliderChange()

        return binding.root
    }

    private fun checkBoxToggleMain(view: View, isChecked: Boolean) {

        binding.checkBoxRadios.isEnabled = isChecked
        binding.checkBoxSlider.isEnabled = isChecked
    }


    private fun checkBoxToggleRadios(view: View, isChecked: Boolean) {

        binding.radioButton.isEnabled = !isChecked
        binding.radioButton2.isEnabled = !isChecked
        binding.radioButton3.isEnabled = !isChecked
    }

    private fun checkBoxToggleSlider(view: View, isChecked: Boolean) {

        binding.slider.isEnabled = !isChecked
    }

    private fun radiosToggle(view: View, checkedId: Int) {

        binding.slider.progress = when (checkedId) {
            binding.radioButton.id -> 1
            binding.radioButton2.id -> 2
            binding.radioButton3.id -> 3
            else -> return
        }
    }

    private fun sliderChange() {

        binding.slider.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                when (progress) {
                    1 -> binding.radioButton.isChecked = true
                    2 -> binding.radioButton2.isChecked = true
                    3 -> binding.radioButton3.isChecked = true
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {

            }
        })
    }

}
