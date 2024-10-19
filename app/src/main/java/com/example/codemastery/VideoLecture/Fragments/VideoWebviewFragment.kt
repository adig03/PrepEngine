package com.example.codemastery.VideoLecture.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.codemastery.R
import com.example.codemastery.databinding.FragmentVideoWebviewBinding

class VideoWebviewFragment : Fragment(R.layout.fragment_video_webview) {

    private val args: VideoWebviewFragmentArgs by navArgs()
    private lateinit var binding: FragmentVideoWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thumbnailUrl = args.VideoUrl
        val videoId = extractVideoId(thumbnailUrl)

        setupWebView(videoId)
    }

    private fun extractVideoId(url: String): String {
        // Regular expression to match video ID from YouTube URL
        val regex = Regex("(?<=v=|/)([\\w-]{11})")
        return regex.find(url)?.value ?: ""
    }

    private fun setupWebView(videoId: String) {
        binding.webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        binding.webView.webChromeClient = WebChromeClient()
        binding.webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                // Handle the error
                // You can show a Toast or an error message here
            }
        }

        val html = """
            <!DOCTYPE html>
            <html>
            <body>
                <div id="player"></div>
                <script src="https://www.youtube.com/iframe_api"></script>
                <script>
                    var player;
                    function onYouTubeIframeAPIReady() {
                        player = new YT.Player('player', {
                            height: '100%',
                            width: '100%',
                            videoId: '$videoId',
                            events: {
                                'onReady': onPlayerReady
                            }
                        });
                    }
                    function onPlayerReady(event) {
                        event.target.playVideo();
                    }
                </script>
            </body>
            </html>
        """.trimIndent()

        binding.webView.loadData(html, "text/html", "utf-8")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the WebView to free up resources
        binding.webView.loadUrl("about:blank")
    }
}
