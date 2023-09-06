package com.curso.android.app.practica.pyfinal02.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.curso.android.app.practica.pyfinal02.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val practicaViewModel: PracticaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition { false }
        practicaViewModel.practicaModel.observe(this) {
            binding.viewModelTextResultado.text = it?.textoResultadoFin
        }

        binding.button2.setOnClickListener {
            val textoUno = binding.textInputUno.text.toString()
            val textoDos = binding.textInputDos.text.toString()
            practicaViewModel.compararTexto(textoUno, textoDos)
        }

        binding.buttonLimpiar.setOnClickListener{
            binding.textInputUno.text = null
            binding.textInputDos.text = null
            practicaViewModel.limpiar()
        }

    }



}