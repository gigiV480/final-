package com.example.hope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var email = findViewById<EditText>(R.id.email1)
        var pasd= findViewById<EditText>(R.id.password1)
        var btn = findViewById<Button>(R.id.createaccbtn)
        var isari = findViewById<ImageView>(R.id.ukanaisari)
        isari.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btn.setOnClickListener {
            if(email.text.toString().isEmpty() or pasd.text.toString().isEmpty()){
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email.text.toString(),pasd.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "acc created", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}