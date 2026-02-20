package com.kotlinimc

import android.icu.text.DecimalFormat
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlinimc.databinding.ActivityMainBinding
import com.kotlinimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        processarResultado()

        binding.btnVoltar.setOnClickListener { finish() }

    }

    private fun processarResultado (){
    val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc",0.0)

        binding.txtNome.text = nome

        val formatador = DecimalFormat("#0.00")
        binding.txtImc.text = "imc: ${formatador.format(imc)}"

        when{
            imc <= 18.5 -> {binding.imgResultado.setImageDrawable(getDrawable(R.drawable.abaixo_peso))}
            imc <= 24.9 -> {binding.imgResultado.setImageDrawable(getDrawable(R.drawable.peso_normal))}
            imc <= 29.9 -> {binding.imgResultado.setImageDrawable(getDrawable(R.drawable.sobrepeso))}
            imc <= 34.9 -> {binding.imgResultado.setImageDrawable(getDrawable(R.drawable.obesidade1))}
            imc <= 39.9 -> {binding.imgResultado.setImageDrawable(getDrawable(R.drawable.obesidade2))}
            imc > 40 -> {binding.imgResultado.setImageDrawable(getDrawable(R.drawable.obesidade3))}


        }
    }
}