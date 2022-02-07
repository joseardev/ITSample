package com.example.itsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.itsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txPruebas.text = "Binding"

        binding.btnBlue.setOnClickListener { loadFragment(BlueFragment()) }
        binding.btnRed.setOnClickListener { replaceFragment(RedFragment()) }
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "El botón ha sido pulsado", Toast.LENGTH_SHORT).show()
    }
    override fun prueba_parametros(text: String) {
        Toast.makeText(this, "Parametro $text", Toast.LENGTH_SHORT).show()
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}