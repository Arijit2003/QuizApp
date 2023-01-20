package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name:TextView=findViewById(R.id.name)
        val start:Button=findViewById(R.id.start)
        start.setOnClickListener(){
            if(name.text.isEmpty()){
                Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent:Intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra("name",name.text.toString())
                startActivity(intent)
                finish()
                

            }
        }
    }
}