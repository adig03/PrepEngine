package com.example.codemastery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codemastery.Models.RecyclerItem
import com.example.codemastery.R

class TopicRVAdapter(val rvItems: List<RecyclerItem>) : RecyclerView.Adapter<TopicRVAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.cardTitleText)
        val itemDesc: TextView = itemView.findViewById(R.id.cardDesc)
        val itemImage: ImageView = itemView.findViewById(R.id.cardImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rvItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = rvItems[position]
        holder.itemImage.setImageResource(item.topicImage)
        holder.itemDesc.text = item.topicDesc
        holder.itemTitle.text = item.topicName

        // Adding a fade-in animation for smooth display
        holder.itemView.alpha = 0f
        holder.itemView.animate().alpha(1f).setDuration(500).start()
    }
}
