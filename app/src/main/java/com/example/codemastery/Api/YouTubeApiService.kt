import com.example.codemastery.Responses.YoutubeResponse
import com.example.codemastery.util.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {

    // Get videos from a specific playlist
    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("part")
        part: String = "snippet",
        @Query("playlistId")
        playlistId: String,
        @Query("key")
        apiKey :String = API_KEY,
        @Query("maxResults")
        maxResults: Int = 2
    ): Response<YoutubeResponse>

    // Search for videos (optional, based on keywords)
    @GET("search")
     suspend fun searchVideos(
        @Query("part") part: String = "snippet",
        @Query("q") query: String,
        @Query("key")
        apiKey :String = API_KEY,
        @Query("type") type: String = "video",

    ): Call<YoutubeResponse>
}