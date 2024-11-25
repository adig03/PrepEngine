package com.example.codemastery.repositiories


import com.example.codemastery.Api.PrepEngineBackendService
import com.example.codemastery.Api.PrepEngineRetrofitInstance
import com.example.codemastery.Api.RetrofitInstance
import com.example.codemastery.Models.QuestionModelX
import com.example.codemastery.Models.SubjectTopicsResponse
import com.example.codemastery.Models.SubjectsResponse
import com.example.codemastery.Models.TopicwiseQuestionResponse
import com.example.codemastery.Responses.YoutubeResponse
import retrofit2.Response

class MainRepository {


suspend fun getAllCategories():Response<SubjectsResponse> {
    return PrepEngineRetrofitInstance.api.getAllCategories()
}

    suspend fun getSubCategories(categoryName:String):Response<SubjectTopicsResponse>{
        return PrepEngineRetrofitInstance.api.getSubCategories(categoryName)
    }

    suspend fun getTopicWiseQuestions(subCategory:String):Response<TopicwiseQuestionResponse>{
        return PrepEngineRetrofitInstance.api.getTopicWiseQuestions(subCategory)
    }

    suspend fun getRandomQuestions():Response<QuestionModelX>{
        return PrepEngineRetrofitInstance.api.getRandomQuestions()
    }



}