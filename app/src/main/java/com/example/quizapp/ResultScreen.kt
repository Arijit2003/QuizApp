package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        val nameNew:TextView=findViewById(R.id.nameNew)
        val score:TextView=findViewById(R.id.score)
        val buttonFinish:Button=findViewById(R.id.buttonFinish)
        // collecting data from QuizQuestionActivity and setting the data to the views
        val newBundle:Bundle=intent.extras!!
        val getName:String?=newBundle.getString("name")
        val getScore:Int=newBundle.getInt("score")
        score.text="Your Score is $getScore out of 10"
        nameNew.text=getName
        buttonFinish.setOnClickListener(){
            val mNewIntent:Intent=Intent(this,MainActivity::class.java)
            startActivity(mNewIntent)
            finish()
        }
    }
}