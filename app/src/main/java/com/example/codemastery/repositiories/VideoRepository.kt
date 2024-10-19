package com.example.codemastery.repositiories

import android.telecom.Call
import com.example.codemastery.Api.RetrofitInstance
import com.example.codemastery.Responses.YoutubeResponse


import retrofit2.Response

class VideoRepository {
    suspend fun getPlaylistVideos(playlistId:String): Response<YoutubeResponse> {
        return RetrofitInstance.api.getPlaylistItems(
            playlistId = playlistId
        )
    }
}

