package com.example.codemastery.Models

data class Subtopic(
    val name :String,
    val questionList:List<QuestionModel>,
){
    constructor():this("" , emptyList())
}
