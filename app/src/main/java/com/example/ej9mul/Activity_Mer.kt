package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import clase.Articulo
import clase.personaje1
import com.example.ej9mul.databinding.ActivityMerBinding
import com.google.firebase.firestore.FirebaseFirestore

class Activity_Mer : AppCompatActivity() {
    lateinit var binding: ActivityMerBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mer)
        binding= ActivityMerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.comerciar.setOnClickListener {
            binding.comprar.visibility = android.view.View.VISIBLE
            binding.vender.visibility = android.view.View.VISIBLE
            binding.cancelar.visibility = android.view.View.VISIBLE
            binding.textView4.visibility = android.view.View.VISIBLE
            binding.textView5.visibility = android.view.View.VISIBLE
            binding.imageView3.visibility = android.view.View.VISIBLE
            binding.numcom.visibility = android.view.View.VISIBLE
            binding.numven.visibility = android.view.View.VISIBLE
            binding.comerciar.visibility = android.view.View.INVISIBLE
            binding.continuar1.visibility = android.view.View.INVISIBLE
        }
        binding.cancelar.setOnClickListener {
            binding.comprar.visibility = android.view.View.INVISIBLE
            binding.vender.visibility = android.view.View.INVISIBLE
            binding.cancelar.visibility = android.view.View.INVISIBLE
            binding.textView4.visibility = android.view.View.INVISIBLE
            binding.textView5.visibility = android.view.View.INVISIBLE
            binding.imageView3.visibility = android.view.View.INVISIBLE
            binding.numcom.visibility = android.view.View.INVISIBLE
            binding.numven.visibility = android.view.View.INVISIBLE
            binding.comerciar.visibility = android.view.View.VISIBLE
            binding.continuar1.visibility = android.view.View.VISIBLE
        }

        binding.comprar.setOnClickListener {
            comprar()

        }
        binding.vender.setOnClickListener {
            vender()
        }

        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            startActivity(intent)
        }

        binding.obj.text = personaje1.getMochila().getContenido().count().toString()
    }
    private fun comprar(){
        if (binding.numcom.text.toString().isNotEmpty()) {
            for (i in 1..binding.numcom.text.toString().toInt()) {
                personaje1.getMochila().addArticulo(Articulo("ObjComprado", 5, 10))
                personaje1.setMonedero(personaje1.getMonedero() - 125)

            }
            db.collection("PersonajesFinales").document("Personaje1").set(personaje1)
        }
    }

    private fun vender(){
        if (binding.numven.text.toString().isNotEmpty()) {
            for (i in 1..binding.numven.text.toString().toInt()) {
                personaje1.getMochila().removeArticulo(personaje1.getMochila().getContenido().last())
                personaje1.setMonedero(personaje1.getMonedero() + 125)

            }
            db.collection("PersonajesFinales").document("Personaje1").set(personaje1)
        }
    }



}

