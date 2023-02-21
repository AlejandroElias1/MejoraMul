package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.ActivityEneBinding

class Activity_Ene : AppCompatActivity() {
    lateinit var binding: ActivityEneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ene)
        binding= ActivityEneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.luchar.setOnClickListener {
            val intent = android.content.Intent(this, Activity_Ene2::class.java)
            startActivity(intent)
        }
        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            startActivity(intent)
        }
    }
}