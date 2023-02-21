package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import clase.Articulo
import clase.personaje1
import com.example.ej9mul.databinding.ActivityObjBinding
import com.google.firebase.firestore.FirebaseFirestore

class Activity_Obj : AppCompatActivity() {
    lateinit var binding: ActivityObjBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obj)
        binding= ActivityObjBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.recoger.setOnClickListener {
            val intent = android.content.Intent(this, Activity_Obj2::class.java)
            if (personaje1.getMochila().getPesoMochila() > 0){
                personaje1.getMochila().addArticulo(Articulo("A1", 5, 10))
                db.collection("PersonajeFinal").document("pParaDaniel").set(personaje1)
            }
            startActivity(intent)
        }
        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            startActivity(intent)
        }
    }

}

