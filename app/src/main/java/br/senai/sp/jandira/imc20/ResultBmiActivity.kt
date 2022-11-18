package br.senai.sp.jandira.imc20

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.jandira.imc20.databinding.ActivityResultBmiBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi

class ResultBmiActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar valores que estão na intent
        val weight = intent.getDoubleExtra("weight", 0.00)
        val high = intent.getDoubleExtra("high", 0.00)
        val resultBmiCalculate = getBmi(weight, high)

        binding.textViewResult.text = String.format("%.2f", resultBmiCalculate)
        binding.textViewStatus.text = getStatusBmi(resultBmiCalculate)

    }
}

