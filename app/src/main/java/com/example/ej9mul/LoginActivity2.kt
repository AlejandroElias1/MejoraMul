package com.example.ej9mul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9mul.databinding.ActivityLogin2Binding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()

        binding.regtext.setOnClickListener {
            val intent = android.content.Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setup(){
        binding.signUpButtonC.setOnClickListener {
            if(binding.pass.text!!.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.email.text.toString(), binding.pass.text.toString())
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = android.content.Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
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