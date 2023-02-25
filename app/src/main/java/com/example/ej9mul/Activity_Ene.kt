package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import clase.Dado
import clase.enemigo1
import clase.personaje1
import com.example.ej9mul.databinding.ActivityEneBinding
import com.google.firebase.firestore.FirebaseFirestore

class Activity_Ene : AppCompatActivity() {
    lateinit var binding: ActivityEneBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ene)
        binding = ActivityEneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ataque=20/ personaje1.getDefensa()
        enemigo1.setFuerza(ataque)

        binding.textViewVidaEne.text = enemigo1.getVida().toString()
        binding.textViewVidaPlayer.text = personaje1.getVida().toString()

        binding.luchar.setOnClickListener {
            combate()
        }

        binding.Huir.setOnClickListener {
            huir()
        }
        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            startActivity(intent)
        }
    }

    private fun combate() {
        val dado = Dado()

        if (personaje1.getVida() > 0 && enemigo1.getVida() > 0) {
            if (dado.tirada() >= 4) {
                enemigo1.setVida(enemigo1.getVida() - personaje1.getFuerza())
                binding.textViewVidaEne.text = enemigo1.getVida().toString()
                //Log.v("vida enemigo", enemigo1.getVida().toString())
            } else {
                binding.fallopop.visibility = View.VISIBLE
                binding.fallopop.postDelayed({
                    binding.fallopop.visibility = View.INVISIBLE
                }, 2000)
            }
            personaje1.setVida(personaje1.getVida() - enemigo1.getFuerza())
            binding.textViewVidaPlayer.text = personaje1.getVida().toString()
            //Log.v("vida player", personaje1.getVida().toString())
        }else{
            val intent = android.content.Intent(this, Activity_Lose::class.java)
            startActivity(intent)
        }
    }
   private fun huir() {
        val dado = Dado()
       if (personaje1.getVida() > 0 && enemigo1.getVida() > 0) {
           if (dado.tirada() > 4) {
               val intent = android.content.Intent(this, Activity_4::class.java)
               startActivity(intent)
           } else {
               personaje1.setVida(personaje1.getVida() - enemigo1.getFuerza())
               binding.textViewVidaPlayer.text = personaje1.getVida().toString()
           }
       }
       db.collection("PersonajesFinales").document("Personaje1").set(personaje1)
        }
    }

