package com.example.quiz

object Constants{
    const val username="name"
    const val total_question="total question"
    const val correct_answer="correct answer"
    fun getQuestion(): ArrayList<Questions>{
        val questionList=ArrayList<Questions>()
        val ques1=Questions(1,"Which country this flag belongs to",R.drawable.america,
            "America","Canada","yemen","Denmark",1)
        val ques2=Questions(1,"Which country this flag belongs to",R.drawable.australia,
            "America","Australia","New Zeland","Denmark",2)
        val ques3=Questions(1,"Which country this flag belongs to",R.drawable.canada,
            "America","Canada","Yemen","Denmark",2)
        val ques4=Questions(1,"Which country this flag belongs to",R.drawable.denmark,
            "America","Canada","yemen","Denmark",4)
        val ques5=Questions(1,"Which country this flag belongs to",R.drawable.england,
            "America","England","Yemen","Denmark",2)
        val ques6=Questions(1,"Which country this flag belongs to",R.drawable.france,
            "America","Canada","France","Denmark",3)
        val ques7=Questions(1,"Which country this flag belongs to",R.drawable.newzeland,
            "Australia","New Zeland","Yemen","Denmark",2)
        val ques8=Questions(1,"Which country this flag belongs to",R.drawable.southafrica,
            "America","Canada","Yemen","South Africa",4)
        val ques9=Questions(1,"Which country this flag belongs to",R.drawable.spain,
            "America","Spain","Yemen","Denmark",2)
        val ques10=Questions(1,"Which country this flag belongs to",R.drawable.yemen,
            "America","Canada","Yemen","Denmark",3)

        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)
        questionList.add(ques4)
        questionList.add(ques5)
        questionList.add(ques6)
        questionList.add(ques7)
        questionList.add(ques8)
        questionList.add(ques9)
        questionList.add(ques10)




        return questionList
    }
}