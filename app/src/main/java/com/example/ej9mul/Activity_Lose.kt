package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.ActivityLoseBinding

class Activity_Lose : AppCompatActivity() {
    lateinit var binding: ActivityLoseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)
        binding= ActivityLoseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.empezar.setOnClickListener {
            val intent = android.content.Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}