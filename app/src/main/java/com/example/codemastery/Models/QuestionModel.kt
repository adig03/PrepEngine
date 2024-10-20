package com.example.codemastery.Models

data class QuestionModel(
    val id: Int,
    val question:String,
    val options :List<String> ,
    val correct:String,
){
    constructor(): this(0,"" , emptyList() , "")

}
