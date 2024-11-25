package com.example.codemastery.Api

import com.example.codemastery.Models.QuestionModelX
import com.example.codemastery.Models.SubjectTopicsResponse
import com.example.codemastery.Models.SubjectTopicsResponseItem
import com.example.codemastery.Models.SubjectsResponse
import com.example.codemastery.Models.TopicwiseQuestionResponse
import com.example.codemastery.Responses.YoutubeResponse
import com.example.codemastery.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PrepEngineBackendService {


// request call for getting all the categories

  @GET("categories/get-categories")
  suspend fun getAllCategories(): Response<SubjectsResponse>


  @GET("questions/random-question")
  suspend fun getRandomQuestions():Response<QuestionModelX>

  @GET("get-subCategory/{categoryName}")
  suspend fun getSubCategories(@Path("categoryName") categoryName: String): Response<SubjectTopicsResponse>


@GET("questions/get-question/{subcategoryName}")
suspend fun  getTopicWiseQuestions(@Path("subcategoryName") subcategoryName :String ):Response<TopicwiseQuestionResponse>
}