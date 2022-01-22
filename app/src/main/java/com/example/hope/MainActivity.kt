package com.example.hope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        if(FirebaseAuth.getInstance().currentUser!=null){
            var intent  = Intent(this,MainActivity3::class.java)
            startActivity(intent)
            finish()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var siginbtn = findViewById<Button>(R.id.sigin)
        var signup = findViewById<Button>(R.id.signup)



        signup.setOnClickListener {
            var intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }

        siginbtn.setOnClickListener {
            var email = findViewById<EditText>(R.id.email)
            var passwd = findViewById<EditText>(R.id.password)
            var email1 = email.text.toString()
            var passwd1 = passwd.text.toString()
            if(email1.isEmpty() or passwd1.isEmpty()){
                Toast.makeText(this, "email or password tasks are empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
//            Toast.makeText(this, "${email.text.toString()},${passwd.text.toString()}", Toast.LENGTH_SHORT).show()
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email.text.toString(),passwd.text.toString())
                .addOnCompleteListener{ task->
                    if(task.isSuccessful){
                        var intent = Intent(this,MainActivity3::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "email or password is incorect", Toast.LENGTH_SHORT).show()
                    }

                }
                }
        }









    }


