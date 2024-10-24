package com.example.codemastery.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codemastery.PdfDisplayActivity
import com.example.codemastery.databinding.PdfItemBinding

class PdfAdapter(private val context: Context, private var pdfNames: List<String>, private var pdfUrls: List<String>) : RecyclerView.Adapter<PdfAdapter.PdfViewHolder>() {

    class PdfViewHolder(private val binding: PdfItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pdfName: String, pdfUrl: String, context: Context) {
            binding.pdfName.text = pdfName
            binding.root.setOnClickListener {
                val intent = Intent(context, PdfDisplayActivity::class.java)
                intent.putExtra("pdfUrl", pdfUrl)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfViewHolder {
        val binding = PdfItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PdfViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PdfViewHolder, position: Int) {
        holder.bind(pdfNames[position], pdfUrls[position], context)
    }

    override fun getItemCount(): Int = pdfNames.size
}
