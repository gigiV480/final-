package com.example.hope

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt
class MainActivity2 : AppCompatActivity() {
    private lateinit var firstNum:TextView
    private lateinit var secondNum:TextView
    private lateinit var resultNum:TextView
    private lateinit var score:TextView
    private lateinit var yes:ImageView
    private lateinit var no:ImageView
    private lateinit var timer:CountDownTimer
    private var score1=0
    lateinit var operator1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        firstNum=findViewById(R.id.firstInteger)
        secondNum=findViewById(R.id.secondInteger)
        resultNum=findViewById(R.id.Result)
        score=findViewById(R.id.score)
        yes=findViewById(R.id.yes)
        no=findViewById(R.id.no)
        //
        operator1=findViewById(R.id.operator)
        var counter=10.0
        var counter2=1
        timer=object :CountDownTimer(3000,1000){
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                gamozaxeba()
            }
        }
            yes.setOnClickListener {
                Toast.makeText(this, counter.toString()+"   "+counter.toInt().toString(), Toast.LENGTH_SHORT).show()

                if (operator1.text == "+") {
                    counter += 0.4

                    var random= Random.nextInt(1,5)
                    var randoma= Random.nextInt(1,5)
                    var randomint1 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint2 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint3 =
                        Random.nextInt((randomint1 + randomint2 - random), (randomint1 + randomint2 + randoma))
                    timer.cancel()
                    var num1 = firstNum.text.toString().toInt()
                    var num2 = secondNum.text.toString().toInt()
                    var num3 = resultNum.text.toString().toInt()
                    if (num1 + num2 == num3) {
                        var random1 = Random.nextInt(1, 3)
                        if (random1 == 1) {
                            operator1.text = "-"
                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text =  Random.nextInt((randomint1 - randomint2 - 2), (randomint1 - randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        } else {
                            operator1.text = "+"
                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text =  Random.nextInt((randomint1 + randomint2 - 2), (randomint1 + randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        }


                    } else {
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("saxeli","GAME OVER")
                        intent.putExtra("score", score1)
                        startActivity(intent)
                        finish()
                    }
                }else if(operator1.text == "-"){
                    counter += 0.4


                    var random= Random.nextInt(1,5)
                    var randoma= Random.nextInt(1,5)
                    var randomint1 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint2 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint3 =
                        Random.nextInt((randomint1 - randomint2 - random), (randomint1 - randomint2 + randoma))
                    timer.cancel()
                    var num1 = firstNum.text.toString().toInt()
                    var num2 = secondNum.text.toString().toInt()
                    var num3 = resultNum.text.toString().toInt()
                    if (num1 - num2 == num3) {
                        var random1 = Random.nextInt(1, 3)
                        if (random1 == 1) {
                            operator1.text = "-"
                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text = Random.nextInt((randomint1 - randomint2 - 2), (randomint1 - randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        } else {
                            operator1.text = "+"

                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text = Random.nextInt((randomint1 + randomint2 - 2), (randomint1 + randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        }


                    } else {
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("saxeli","GAME OVER")
                        intent.putExtra("score", score1)
                        startActivity(intent)
                        finish()
                    }

                }
            }
            no.setOnClickListener {
                Toast.makeText(this, counter.toString()+"  "+counter.toInt().toString(), Toast.LENGTH_SHORT).show()

                if (operator1.text == "+") {
                    counter += 0.4

                    var random= Random.nextInt(1,4)
                    var randoma= Random.nextInt(1,4)
                    var randomint1 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint2 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint3 =
                        Random.nextInt((randomint1 + randomint2 - random)..(randomint1 + randomint2 + randoma))
                    timer.cancel()

                    var num1 = firstNum.text.toString().toInt()
                    var num2 = secondNum.text.toString().toInt()
                    var num3 = resultNum.text.toString().toInt()

                    if (num1 + num2 == num3) {
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity2, MainActivity::class.java)
                        intent.putExtra("saxeli","GAME OVER")
                        timer.cancel()
                        intent.putExtra("score", score1)
                        startActivity(intent)

                    } else {
                        var random1 = Random.nextInt(1, 3)
                        if (random1 == 1) {
                            operator1.text = "-"

                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text = Random.nextInt((randomint1 - randomint2 - 2), (randomint1 - randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()

                        } else {
                            operator1.text = "+"

                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text = Random.nextInt((randomint1 + randomint2 - 2), (randomint1 + randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        }

                    }
                } else if (operator1.text == "-") {
                    counter += 0.4

                    var random= Random.nextInt(1,4)
                    var randoma= Random.nextInt(1,4)
                    var randomint1 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint2 = Random.nextInt(counter2.toInt(), counter.toInt())
                    var randomint3 =
                        Random.nextInt((randomint1 - randomint2 - random)..(randomint1 - randomint2 + randoma))
                    timer.cancel()

                    var num1 = firstNum.text.toString().toInt()
                    var num2 = secondNum.text.toString().toInt()
                    var num3 = resultNum.text.toString().toInt()

                    if (num1 - num2 == num3) {
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        timer.cancel()
                        intent.putExtra("saxeli","GAME OVER")
                        intent.putExtra("score", score1)
                        startActivity(intent)
                        finish()
                    } else {
                        var random1 = Random.nextInt(1, 3)
                        if (random1 == 1) {
                            operator1.text = "-"

                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text = Random.nextInt((randomint1 - randomint2 - 2), (randomint1 - randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        } else {
                            operator1.text = "+"

                            timer.start()
                            firstNum.text = randomint1.toString()
                            secondNum.text = randomint2.toString()
                            resultNum.text = Random.nextInt((randomint1 + randomint2 - 2), (randomint1 + randomint2 + 2)).toString()
                            score1++
                            score.text = score1.toString()
                        }

                    }
                }


            }
    }
    fun gamozaxeba(){
        lateinit var score:TextView
        Toast.makeText(this, "time out!", Toast.LENGTH_SHORT).show()
        score=findViewById(R.id.score)
        var score1=score.text.toString()
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("saxeli","game over")
        intent.putExtra("score",score1.toInt())
        startActivity(intent )
        finish()

    }

}