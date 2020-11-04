package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    fun start(view: View) {
        if(editText.text.toString().isEmpty()){
            Toast.makeText(this,"Please Enter your Name",Toast.LENGTH_SHORT).show()
        }
        else{
            val intent=Intent(this,QuizQuestion::class.java)
            intent.putExtra(Constants.username,editText.text.toString())
            startActivity(intent)
            finish()

        }
    }
}