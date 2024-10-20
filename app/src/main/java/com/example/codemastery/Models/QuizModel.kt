package com.example.codemastery.Models

data class QuizModel(
    val title:String,
    val subtitle :String,
    val time :String,
    val QuestionList: List<QuestionModel>
){
    constructor():this("" ,"" ,"" , emptyList())
}


