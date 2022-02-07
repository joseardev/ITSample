package com.example.itsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.itsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txPruebas.text = "Binding"
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "El botón ha sido pulsado", Toast.LENGTH_SHORT).show()
    }
    override fun prueba_parametros(text: String) {
        Toast.makeText(this, "Parametro $text", Toast.LENGTH_SHORT).show()
    }

}