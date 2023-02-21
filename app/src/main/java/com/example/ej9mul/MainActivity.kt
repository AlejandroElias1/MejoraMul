package com.example.ej9mul

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ej9mul.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        camImage(binding)

        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, Activity_2::class.java)
            intent.putExtra("clase", binding.imageView.contentDescription)
            startActivity(intent)
        }
    }

    fun camImage(binding: ActivityMainBinding){

        binding.guerrero.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.guerrero)
            binding.imageView.contentDescription = "guerrero"
        }
        binding.mago.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.mago)
            binding.imageView.contentDescription = "mago"
        }
        binding.clerigo.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.clerigo)
            binding.imageView.contentDescription = "clerigo"
        }
        binding.ladron.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.ladron)
            binding.imageView.contentDescription = "ladron"
        }
    }
}

