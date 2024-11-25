package com.example.codemastery.Models

data class SubjectTopicsResponseItem(
    val __v: Int,
    val _id: String,
    val image: String,
    val name: String,
    val questions: List<String>
)