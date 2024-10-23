package com.example.codemastery.Models

data class QModel(
    val id:Int,
    val Question:String,
    val Options:List<String>,
    val Correct:Int
)
