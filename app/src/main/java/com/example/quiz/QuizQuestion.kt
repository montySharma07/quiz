package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestion : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition :Int=1
    private var mQuestionList:ArrayList<Questions>?=null
    private var mSelectedOption:Int=0
    private var mCorrectAnswer:Int=0
    private var musername:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        musername=intent.getStringExtra(Constants.username)

        mQuestionList=Constants.getQuestion()
        setQuestion()
        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)
        submit.setOnClickListener(this)




    }
    private fun setQuestion(){
        defaultoption()
        val question=mQuestionList!![mCurrentPosition-1]
        pgbar.progress=mCurrentPosition
        if(mCurrentPosition>mQuestionList!!.size) submit.text=getString(R.string.finish)
        else submit.text=getString(R.string.next)
        pgtv.text="$mCurrentPosition ${pgbar.max}"
        flagimage.setImageResource(question.image)
        tv.text= question.Question
        op1.text=question.optionOne
        op2.text=question.optionTwo
        op3.text=question.optionThree
        op4.text=question.optionFour
    }
    private fun defaultoption(){
        val options=ArrayList<TextView>()
        options.add(0,op1)
        options.add(1,op2)
        options.add(2,op3)
        options.add(3,op4)
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.optionbg)
        }
    }
    private fun optionselected(tv:TextView,selectedoption:Int){
        defaultoption()
        mSelectedOption=selectedoption

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.optionselected)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.op1->{
                optionselected(op1,1)
            }
            R.id.op2->{
                optionselected(op2,2)
            }
            R.id.op3->{
                optionselected(op3,3)
            }
            R.id.op4->{
                optionselected(op4,4)
            }
            R.id.submit->{
                if(mSelectedOption==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent=Intent(this,Result::class.java)
                            intent.putExtra(Constants.username,musername)
                            intent.putExtra(Constants.correct_answer,mCorrectAnswer)
                            intent.putExtra(Constants.total_question,mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question= mQuestionList?.get(mCurrentPosition-1)

                    if(question!!.correctAnswer!=mSelectedOption){
                        answerView(mSelectedOption,R.drawable.bgwrong)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.bgcurrect)
                    if(mCurrentPosition==mQuestionList!!.size){
                        submit.text=getString(R.string.finish)
                    }
                    else{
                        submit.text=getString(R.string.go)
                    }
                    mSelectedOption=0
                }

            }
        }
    }

    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1->{
                op1.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                op2.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                op3.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                op4.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


}