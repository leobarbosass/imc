package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandira.imc20.model.User

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        val user = Intent()
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProfile()
        binding.buttonCalculate.setOnClickListener{

            bmiCalculate()

        }
    }

    private fun bmiCalculate() {
        val openResult = Intent(this, ResultBmiActivity::class.java)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        val user = User()
        val editor = dados.edit()


        if(binding.editTextWeightCalculate.text.isEmpty()){
            val weight = dados.getInt("weight", 0)
            openResult.putExtra("weight", weight)

        }else {
            user.wheight = binding.editTextWeightCalculate.text.toString().toInt()
            editor.putInt("weight", user.wheight)
            openResult.putExtra("weight", binding.editTextWeightCalculate.text.toString().toDouble())

        }
        if (binding.editTextHighCalculate.text.isEmpty()){
            val height = dados.getFloat("high", 0.0F)
            openResult.putExtra("high", height.toDouble())
        }
        else{
            user.height = binding.editTextHighCalculate.text.toString().toDouble()
            editor.putFloat("high", user.height.toFloat())
            openResult.putExtra("high", binding.editTextHighCalculate.text.toString().toDouble())
        }

        editor.commit()
        startActivity(openResult)
    }


    private fun loadProfile() {

        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewHigh.text = "High: ${dados.getFloat("height", 0.00F)}"
        binding.textViewWeight.text = "Weight: ${dados.getInt("weight", 0)}"
        binding.textViewEmail.text = dados.getString("email", "")

    }


}