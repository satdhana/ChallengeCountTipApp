package com.dafa.challengecounttipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.dafa.challengecounttipapp.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{ calculateTip() }
    }

    private fun calculateTip() {
        val cost : Double = binding.inputTip.text.toString().toDouble()
        val selectedId : Int = binding.radioGroup.checkedRadioButtonId
        val tipPercentage : Double = when(selectedId) {
            R.id.button_a -> 0.2
            R.id.button_b -> 0.18
            else -> 0.15
        }
        var tip : Double = cost*tipPercentage
        val roundUp : Boolean = binding.switchRound.isChecked
        if (roundUp){
            tip = ceil(tip)
        }
        val currentTip : String = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = currentTip
    }
}