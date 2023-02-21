package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.ActivityMerBinding

class Activity_Mer : AppCompatActivity() {
    lateinit var binding: ActivityMerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mer)
        binding= ActivityMerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.comerciar.setOnClickListener {
            binding.comprar.visibility = android.view.View.VISIBLE
            binding.vender.visibility = android.view.View.VISIBLE
            binding.cancelar.visibility = android.view.View.VISIBLE
            binding.comerciar.visibility = android.view.View.INVISIBLE
            binding.continuar1.visibility = android.view.View.INVISIBLE
        }
        binding.cancelar.setOnClickListener {
            binding.comprar.visibility = android.view.View.INVISIBLE
            binding.vender.visibility = android.view.View.INVISIBLE
            binding.cancelar.visibility = android.view.View.INVISIBLE
            binding.comerciar.visibility = android.view.View.VISIBLE
            binding.continuar1.visibility = android.view.View.VISIBLE
        }
        binding.comprar.setOnClickListener {
            binding.imageView3.visibility = android.view.View.VISIBLE
        }

        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_4::class.java)
            startActivity(intent)
        }
    }
}