package com.example.hope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var btn:Button
    lateinit var lastScore:TextView
    lateinit var record:TextView
    lateinit var gameover:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      lastScore=findViewById(R.id.textView2)
      btn = findViewById(R.id.button)

      gameover = findViewById(R.id.gameOver)
     //   Toast.makeText(this, lastScore.text.toString(), Toast.LENGTH_SHORT).show()
      btn.setOnClickListener {
          val intent = Intent(this, MainActivity2::class.java)
          startActivity(intent)
      }

        val ss:String = intent.getStringExtra("saxeli").toString()
        var sss: Int = intent.getIntExtra("score",0)

        gameover.text=ss
        lastScore.text="${sss.toString()}"

        if(gameover.text.toString()=="null"){
            gameover.text=""
        }






}
}

