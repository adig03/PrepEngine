package com.example.codemastery.VideoLecture.Fragments

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.codemastery.R
import com.example.codemastery.databinding.FragmentVideoWebviewBinding

class VideoWebviewFragment : Fragment(R.layout.fragment_video_webview) {

    private val args: VideoWebviewFragmentArgs by navArgs()
    private lateinit var binding: FragmentVideoWebviewBinding
    private var videoId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoId = extractVideoId(args.VideoUrl)
        setupWebView()

        if (savedInstanceState == null) {
            loadVideo()
        }
    }

    private fun extractVideoId(url: String): String {
        val regex = Regex("(?<=v=|/)([\\w-]{11})")
        return regex.find(url)?.value ?: ""
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        binding.webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            domStorageEnabled = true
            mediaPlaybackRequiresUserGesture = false
        }

        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100) {
                    binding.progressBar.isVisible = false
                }
            }
        }

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.isVisible = false
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                binding.progressBar.isVisible = false
                Toast.makeText(context, "Error loading video: ${error?.description}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadVideo() {
        val html = """
            <!DOCTYPE html>
            <html>
            <body style="margin:0;padding:0;">
                <div id="player" style="position:absolute;top:0;left:0;width:100%;height:100%;"></div>
                <script src="https://www.youtube.com/iframe_api"></script>
                <script>
                    var player;
                    function onYouTubeIframeAPIReady() {
                        player = new YT.Player('player', {
                            height: '100%',
                            width: '100%',
                            videoId: '$videoId',
                            playerVars: {
                                'autoplay': 1,
                                'playsinline': 1,
                                'enablejsapi': 1,
                                'modestbranding': 1,
                                'rel': 0
                            },
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

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.webView.saveState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let { binding.webView.restoreState(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.webView.loadUrl("about:blank")
        binding.webView.clearHistory()
    }
}