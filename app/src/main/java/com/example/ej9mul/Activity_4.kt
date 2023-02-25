package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.Activity4Binding

lateinit var binding:Activity4Binding
class Activity_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        dado2(binding)


    }

    fun dado2(binding: Activity4Binding) {
        var dado = (1..4).random()
        when (dado) {
            1 -> {
                com.example.ej9mul.binding.dado.setOnClickListener {
                    val intent = android.content.Intent(this, Activity_Obj::class.java)
                    startActivity(intent)
                }
            }
            2 -> {
                com.example.ej9mul.binding.dado.setOnClickListener {
                    val intent = android.content.Intent(this, Activity_Ciu::class.java)
                    startActivity(intent)
                }
            }
            3 -> {
                com.example.ej9mul.binding.dado.setOnClickListener {
                    val intent = android.content.Intent(this, Activity_Mer::class.java)
                    startActivity(intent)
                }
            }
            4 -> {
                com.example.ej9mul.binding.dado.setOnClickListener {
                    val intent = android.content.Intent(this, Activity_Ene::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}

