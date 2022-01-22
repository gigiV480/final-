package com.example.hope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*

class MainActivity3 : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var lastScore: TextView
    lateinit var record:TextView
    lateinit var gameover:TextView
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("userRecords")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        lastScore=findViewById(R.id.textView2)
        btn = findViewById(R.id.button)
        var signout = findViewById<Button>(R.id.signout)


        gameover = findViewById(R.id.gameOver)
        var lastscore =0
        var recprd =0
        var sss: Int = intent.getIntExtra("score",0)
        lastScore.text="${sss.toString()}"
        do {
            var recpord1 = findViewById<TextView>(R.id.record)

            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    var user = snapshot.getValue(userRecord::class.java)
                    if (user != null) {
                        lastscore = user.lastscore.toInt()
                        recprd = user.record.toInt()

                        if (sss<=recprd){

                            var lastscor1 = sss.toString()
                            var record1 = recprd.toString()
                            var user2 = userRecord(lastscor1,record1)
                            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).setValue(user2)

                            recpord1.text= record1.toString()
                            sss= 0



                        }else{
                            var lastscore1= sss.toString()
                            var record1 = sss.toString()
                            var user2 =  userRecord(lastscore1,record1)
                            db.child(FirebaseAuth.getInstance().currentUser?.uid!!).setValue(user2)
                            var recpord1 = findViewById<TextView>(R.id.record)
                            recpord1.text= record1.toString()
                            sss= 0


                        }

                    }else{

                        var lastscore1= sss.toString()
                        var record1 = sss.toString()
                        var user2 =  userRecord(lastscore1,record1)
                        db.child(FirebaseAuth.getInstance().currentUser?.uid!!).setValue(user2)
                        recpord1.text= record1.toString()
                        sss= 0
                    }
                }



            })

            break
            sss= 0
        }while (sss>0)


        btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        val ss:String = intent.getStringExtra("saxeli").toString()


        gameover.text=ss


        if(gameover.text.toString()=="null"){
            gameover.text=""
        }

        signout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
//
//        var user = userRecord1("1")
//       db.child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(user)



    }
}