package com.kotlinimc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlinimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btbCalcular.setOnClickListener {
            calculaIMC()
        }

    }
    private fun calculaIMC(){

        val nome = binding.edtNome.text.toString()
        val altura = binding.edtAltura.text.toString().toDouble()
        val peso = binding.edtPeso.text.toString().toDouble()

        val imc = (peso / (altura * altura) )

        navegarResultado(nome, imc)
    }
    private fun navegarResultado (nome: String, imc: Double){
        val intent = Intent (this, ResultadoActivity::class.java)
        intent.putExtra("nome", nome)
        intent.putExtra("imc", imc)
        startActivity(intent)
            Log.d("info-imc", "imc: $imc")

    }
}