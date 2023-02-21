package com.example.ej9mul

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import clase.Personaje
import clase.personaje1
import com.example.ej9mul.databinding.Activity3Binding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class Activity_3 : AppCompatActivity() {
    lateinit var binding: Activity3Binding
    private val db = FirebaseFirestore.getInstance()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val clase = bundle?.getString("clase")
        val raza = bundle?.getString("raza")

        when(intent.getStringExtra("raza")){
            "elfo" -> {
                binding.im2.setImageResource(R.drawable.elfo)
                binding.textView.text = "Elfo"
            }
            "humano" -> {
                binding.im2.setImageResource(R.drawable.humano)
                binding.textView.text = "Humano"
            }
            "enano" -> {
                binding.im2.setImageResource(R.drawable.enano)
                binding.textView.text = "Enano"
            }
            "goblin" -> {
                binding.im2.setImageResource(R.drawable.goblin)
                binding.textView.text = "goblin"
            }
        }


        when(intent.getStringExtra("clase")){
            "guerrero" -> {
                binding.im1.setImageResource(R.drawable.guerrero)
                binding.textView2.text = "Guerrero"
            }
            "mago" -> {
                binding.im1.setImageResource(R.drawable.mago)
                binding.textView2.text = "Mago"
            }
            "clerigo" -> {
                binding.im1.setImageResource(R.drawable.clerigo)
                binding.textView2.text = "Clerigo"
            }
            "ladron" -> {
                binding.im1.setImageResource(R.drawable.ladron)
                binding.textView2.text = "Ladron"
            }
        }
        binding.editTextTextPersonName.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                personaje1.setNombre(binding.editTextTextPersonName.text.toString())
                binding.continuar1.isEnabled = binding.editTextTextPersonName.text.toString().isNotEmpty()
            }
        })

        var fuerza = (1..10).random()
        var defensa = (1..5).random()

        binding.variables.text = "Fuerza: $fuerza\n" +
                                 "Defensa: $defensa\n" +
                                 "TamMoch: 100\n" +
                                 "Vida: 200\n" +
                                 "Monedero: - "
        personaje1.setRaza(raza!!)
        personaje1.setClase(clase!!)
        personaje1.setFuerza(fuerza)
        personaje1.setDefensa(defensa)

        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            db.collection("PersonajeFinal").document("pParaDaniel").set(personaje1)
            startActivity(intent)
        }

        binding.volver.setOnClickListener {
            val intent = android.content.Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
