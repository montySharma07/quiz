package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username=intent.getStringExtra(Constants.username)
        val totalquestion=intent.getIntExtra(Constants.total_question,0)
        val corretanswer=intent.getIntExtra(Constants.correct_answer,0)
        tv_username.text="$username"
        tv_score.text="you Score is $corretanswer out of $totalquestion"
        finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}