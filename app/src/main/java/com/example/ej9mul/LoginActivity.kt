package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        title = "Autenticacion"
        binding.signUpButtonC.setOnClickListener {
            if (binding.email.text!!.isNotEmpty() && binding.pass.text!!.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.text.toString(),
                    binding.pass.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = android.content.Intent(this, LoginActivity2::class.java)
                        startActivity(intent)
                    }else {
                        showAlert()
                    }
                }
            }

        }

    }

    private fun showAlert() {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }
}