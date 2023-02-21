package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.ActivityCiuBinding

class Activity_Ciu : AppCompatActivity() {
    lateinit var binding: ActivityCiuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciu)
        binding= ActivityCiuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entrar.setOnClickListener {
            val intent = android.content.Intent(this, Activity_Ciu2::class.java)
            startActivity(intent)
        }
        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            startActivity(intent)
        }
    }
}