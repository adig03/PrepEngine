package com.example.codemastery.VModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codemastery.Responses.Item
import com.example.codemastery.Responses.YoutubeResponse
import com.example.codemastery.repositiories.VideoRepository
import com.example.codemastery.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class VideoLectureViewModels(private val repository: VideoRepository) : ViewModel() {

    private val _videoList = MutableLiveData<Resource<List<Item>>>()
    val videoList: LiveData<Resource<List<Item>>> get() = _videoList

    fun fetchPlaylistVideos(playlistId: String) = viewModelScope.launch {
        _videoList.postValue(Resource.Loading())
        val response = repository.getPlaylistVideos(playlistId)
        _videoList.postValue(handleVideoList(response))
    }

    private fun handleVideoList(response: Response<YoutubeResponse>): Resource<List<Item>> {
        return if (response.isSuccessful) {
            response.body()?.let { result ->
                Resource.Success(result.items)
            } ?: Resource.Error("No data found")
        } else {
            Resource.Error("Error: ${response.message()}")
        }
    }
}
