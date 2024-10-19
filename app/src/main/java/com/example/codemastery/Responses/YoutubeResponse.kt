package com.example.codemastery.Responses

data class YoutubeResponse(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)