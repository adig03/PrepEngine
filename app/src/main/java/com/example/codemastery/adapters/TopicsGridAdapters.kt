package com.example.codemastery.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.codemastery.Models.SubTopicGridItem
import com.example.codemastery.pdf.PdfActivity
import com.example.codemastery.R
import com.example.codemastery.VideoLecture.VideoLectureActivity
import com.example.codemastery.WorkinProgressActivity

class TopicsGridAdapters(
    private val context: Context,  // Context reference
    private val gridItems: ArrayList<SubTopicGridItem>,
    private val subject: String
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = gridItems.size

    override fun getItem(position: Int): Any = gridItems[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View = convertView ?: inflater.inflate(R.layout.topics_rv_item, parent, false)

        val currentItem = gridItems[position]

        val gridText: TextView = itemView.findViewById(R.id.cardTitleText)
        val gridImage: ImageView = itemView.findViewById(R.id.cardImageView)

        gridText.text = currentItem.Title
        gridImage.setImageResource(currentItem.imageView)

        itemView.setOnClickListener {
            if (currentItem.Title == "Video Lectures") {
                val intent = Intent(context, VideoLectureActivity::class.java).apply {
                    putExtra("subject", subject)
                }
                context.startActivity(intent)
            }
            else if(currentItem.Title == "Flash Cards"){
                val i = Intent(context , PdfActivity::class.java).apply {
                    putExtra("subject" , subject )
                }
                it.context.startActivity(i)
            }
            else{
                val intent = Intent(context , WorkinProgressActivity::class.java)
                it.context.startActivity(intent)
            }
        }

        return itemView
    }
}
