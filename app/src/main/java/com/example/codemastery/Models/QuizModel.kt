package com.example.codemastery.Models

data class QuizModel(
    val title: String,
    val subtitle: String,
    val time: Int,
    val questionList: MutableList<QuestionModelItem>
) {
    constructor() : this("", "", 0, ArrayList())
}



