package com.example.codemastery.pdf

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codemastery.R
import com.example.codemastery.adapters.PdfAdapter
import com.example.codemastery.databinding.ActivityPdfBinding
import com.example.codemastery.viewModels.PdfViewModel
import com.example.codemastery.viewModels.PdfViewModelFactory

class PdfActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPdfBinding
    private lateinit var pdfViewModel: PdfViewModel
    private lateinit var pdfAdapter: PdfAdapter
    private lateinit var listOfNames: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val repository = PdfRepository()
        val factory = PdfViewModelFactory(repository)
        pdfViewModel = ViewModelProvider(this, factory)[PdfViewModel::class.java]

        val subject = intent.getStringExtra("subject")
        binding.toolbarPdf.title = subject
        binding.toolbarPdf.setNavigationOnClickListener {
            finish()
        }

        binding.rvPdfs.apply {
            layoutManager = LinearLayoutManager(this@PdfActivity)
            pdfAdapter = PdfAdapter(this@PdfActivity, emptyList(), emptyList())
            adapter = pdfAdapter
        }

        // Show progress bar when fetching PDFs
        binding.loadingPdf.visibility = View.VISIBLE // Show ProgressBar

        subject?.let {
            pdfViewModel.getPdfs(it)
        }

        pdfViewModel.pdfNames.observe(this) { urls ->
            listOfNames = mutableListOf<String>()
            urls.forEach { url ->
                val uri = Uri.parse(url)
                val pdfName = uri.lastPathSegment ?: "Unknown"
                listOfNames.add(pdfName)
            }
        }

        pdfViewModel.pdfUrls.observe(this) { urls ->
            // Hide ProgressBar once data is fetched
            binding.loadingPdf.visibility = View.GONE // Hide ProgressBar

            binding.rvPdfs.apply {
                pdfAdapter = PdfAdapter(this.context, listOfNames, urls)
                adapter = pdfAdapter
            }
        }
    }
}
