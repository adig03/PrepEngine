package com.example.codemastery

import android.graphics.pdf.PdfRenderer
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.codemastery.databinding.ActivityPdfDisplayBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class PdfDisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdfDisplayBinding
    private lateinit var pdfRenderer: PdfRenderer
    private lateinit var parcelFileDescriptor: ParcelFileDescriptor
    private var currentPageIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pdfUrl = intent.getStringExtra("pdfUrl")
        if (pdfUrl != null) {
            downloadAndDisplayPdf(pdfUrl)
        }

        binding.pdfTool.setNavigationOnClickListener {
            finish()
        }

        // Set up swipe functionality
        binding.nextPageBtn.setOnClickListener {
            nextPage()
        }

        binding.prevPageBtn.setOnClickListener {
            previousPage()
        }
    }

    private fun downloadAndDisplayPdf(pdfUrl: String) {
        binding.pdfProgress.visibility = ProgressBar.VISIBLE // Show the progress bar
        CoroutineScope(Dispatchers.IO).launch {
            val file = downloadPdfFile(pdfUrl)
            withContext(Dispatchers.Main) {
                binding.pdfProgress.visibility = ProgressBar.GONE // Hide the progress bar
                if (file != null) {
                    displayPdf(file)
                } else {
                    showToast("Error downloading PDF")
                }
            }
        }
    }

    private suspend fun downloadPdfFile(pdfUrl: String): File? {
        return try {
            val url = URL(pdfUrl)
            val connection = url.openConnection()
            connection.connect()

            val inputStream = connection.getInputStream()
            val file = File(cacheDir, "temp_pdf_file.pdf")
            val outputStream = FileOutputStream(file)

            val buffer = ByteArray(1024)
            var bytesRead: Int
            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }

            outputStream.close()
            inputStream.close()

            file
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun displayPdf(file: File) {
        parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
        pdfRenderer = PdfRenderer(parcelFileDescriptor)

        if (pdfRenderer.pageCount > 0) {
            currentPageIndex = 0
            renderPage(currentPageIndex)
        }
    }

    private fun renderPage(index: Int) {
        if (index >= 0 && index < pdfRenderer.pageCount) {
            val page = pdfRenderer.openPage(index)
            val bitmap = android.graphics.Bitmap.createBitmap(
                page.width,
                page.height,
                android.graphics.Bitmap.Config.ARGB_8888
            )
            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            binding.pdfImageView.setImageBitmap(bitmap)
            page.close()
        }
    }

    private fun nextPage() {
        if (currentPageIndex < pdfRenderer.pageCount - 1) {
            currentPageIndex++
            renderPage(currentPageIndex)
        }
    }

    private fun previousPage() {
        if (currentPageIndex > 0) {
            currentPageIndex--
            renderPage(currentPageIndex)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        pdfRenderer.close()
        parcelFileDescriptor.close()
    }
}
