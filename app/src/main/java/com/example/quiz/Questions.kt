package com.example.quiz

import android.graphics.drawable.Drawable

data class Questions (
    val id:Int,
    val Question:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)