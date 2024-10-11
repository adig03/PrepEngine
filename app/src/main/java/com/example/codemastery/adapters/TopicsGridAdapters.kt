package com.example.codemastery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.codemastery.Models.SubTopicGridItem
import com.example.codemastery.R
import com.example.codemastery.R.layout.topics_rv_item

class  TopicsGridAdapters(context: Context, val GridItems: ArrayList<SubTopicGridItem>): BaseAdapter() {
    val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return GridItems.size
    }

    override fun getItem(p0: Int): Any {
        return GridItems[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView: View = p1 ?: inflater.inflate(topics_rv_item, p2, false)

       val currentItem = GridItems[p0]

        val gridText: TextView = itemView.findViewById<TextView>(R.id.cardTitleText)
        val gridImage: ImageView = itemView.findViewById<ImageView>(R.id.cardImageView)

        gridText.text = currentItem.Title
        gridImage.setImageResource(currentItem.imageView)

        return itemView

    }
}
